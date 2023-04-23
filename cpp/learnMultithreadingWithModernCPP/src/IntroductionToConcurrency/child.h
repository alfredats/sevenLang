#pragma once
#include <iostream>

class Child {
public:
    Child(std::string);
    ~Child();
    std::string name;
    void fizzbuzz(unsigned int);
    void announce();
};
