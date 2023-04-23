#pragma once

#include <iostream>
#include <thread>
#include <vector>

#include "child.h"

void carousel(std::string&& s) {
    std::vector<Child> carousel{}; 
    carousel.push_back(Child{"Abdul"});
    carousel.push_back(Child{"Bart"});
    carousel.push_back(Child{"Claudia"});

    for (int i = 0; i < 100; i++) {
        carousel.at(i%3).fizzbuzz(i);
    }

    std::cout << "carousel was called from thread " << s << std::endl;
    return;
}


int main() {
    std::string threadname{"t0"};
    // we use std::move to transfer ownership of object threadname to t0
    std::thread t0{carousel, std::move(threadname)};
    t0.join();

    Child c0{"Denny"};
    std::thread t1{&Child::announce, &c0};
    t1.join();

    return 0;
}



