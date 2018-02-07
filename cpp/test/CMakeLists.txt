set(Boost_USE_STATIC_LIBS OFF) 
set(Boost_USE_MULTITHREADED ON)  
set(Boost_USE_STATIC_RUNTIME OFF) 
find_package(Boost REQUIRED COMPONENTS unit_test_framework)
include_directories("${PROJECT_SOURCE_DIR}/include")
if(Boost_FOUND)
  include_directories(${Boost_INCLUDE_DIRS})
endif()

set(TEST_SOURCES ${PROJECT_SOURCE_DIR}/test/QuickStartTest.cpp)
set(TEST_LIBS QuickStart)

add_executable(test_main ${TEST_SOURCES})
target_link_libraries(test_main ${TEST_LIBS} ${Boost_LIBRARIES})
add_test(QuickStartTest test_main COMMAND test_main)

set(TEST_SOURCES ${PROJECT_SOURCE_DIR}/test/test_quick_select.cpp)
set(TEST_LIBS QuickStart)

add_executable(test_quick_select ${TEST_SOURCES})
target_link_libraries(test_quick_select ${TEST_LIBS} ${Boost_LIBRARIES})
add_test(QuickSelectTest test_quick_select COMMAND test_quick_select)