#include "child.h"

Child::Child(std::string n) : name(n) {};
Child::~Child() {};

void Child::fizzbuzz(unsigned int i) {
    std::string say{""};
    if (!(i%3)) { say.append("fizz"); }
    if (!(i%5)) { say.append("buzz"); }
    if (say.size() == 0) { say.append(std::to_string(i)); }
    std::cout << name << " says " << say << std::endl;
}

void Child::announce() {
    std::cout << "My name is " << this->name << std::endl;
}
