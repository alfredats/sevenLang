#pragma once

#include <thread>
#include <iostream>
#include "threadguard.h"


// display thread id
void hello() {
  // some notes:
  // - each execution thread has a thread identifier
  // - thread identifiers are guaranteed unique
  std::cout << "Hello from thread with ID " << std::this_thread::get_id() << '\n';
  std::this_thread::sleep_for(std::chrono::seconds(3));
}

void receiver(std::thread&& t) {
  // receiver function now "owns" the system thread 
  // notice that the movement occurs while thread thr is still asleep

  // the next statement runs on the main thread
  std::cout << "Received thread with ID " << t.get_id() << std::endl;

  // receiver function is responsible for calling "join"
  t.join();
  return;
}

std::thread creator() {
  // function returning a std::thread object
  std::thread thr(hello); // thread created in 'creator'
  std::cout << "Creator created thread with ID " << thr.get_id() << std::endl;
  return thr;
}

// a note on exception handling
// - exceptions must be handled within the invocation function called when 
//   initializing the thread (use a normal try-catch block)
// - other threads in the program (including parent & main thread) cannot 
//   catch the exception


// receiver 
int main() {

  std::cout << ">>> receiver" << std::endl;
  std::cout << "Main thread has ID " << std::this_thread::get_id() << '\n';

  std::thread thr(hello);
  std::cout << "Hello thread has ID " << thr.get_id() << '\n';
  // thr.join();

  receiver(std::move(thr));
  std::cout << "Hello thread now has ID " << thr.get_id() << '\n';


  std::cout << "\n\n" << std::endl;
  std::cout << ">>> creator" << std::endl;
  std::thread thr2 = creator();
  std::cout << "Main thread received thread with ID " << thr2.get_id() << '\n';
  thr2.join(); // 'main' now owns thread created in 'creator' and hence must call 'join'


  std::cout << "\n\n" << std::endl;
  std::cout << ">>> detaching a thread" << std::endl;
  // we can call 'detach()' to allow child threads to run independently of 
  // parent thread
  // - 'join()' makes parent thread wait for child thread to complete
  try {
    // graceful termination of a child thread when main thread throws error
    std::thread thr3(hello);
    threadguard tg{std::move(thr3)};

    throw std::exception();
    // ~threadguard is called, followed by ~thread
  } 
  catch (std::exception& e) {
    std::cout << "Exception caught: " << e.what() << std::endl;
  }


  return 0;
}
