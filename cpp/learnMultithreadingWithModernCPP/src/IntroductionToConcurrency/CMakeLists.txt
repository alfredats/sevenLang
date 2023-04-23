cmake_minimum_required(VERSION 3.10)
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

project(introductionToConcurrency VERSION 1.0)
# target_include_directories(introductionToConcurrency PUBLIC ${CMAKE_CURRENT_SOURCE_DIR}/../../include)
add_executable(introductionToConcurrency main.cpp)

add_library(Child child.cpp)
list(APPEND EXTRA_LIBS Child)

target_link_libraries(introductionToConcurrency PUBLIC ${EXTRA_LIBS})
target_include_directories(introductionToConcurrency PUBLIC "${PROJECT_BINARY_DIR}")
