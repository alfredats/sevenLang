#include <thread>

class threadguard {
  std::thread thr;
public:
  explicit threadguard(std::thread&& thr) : thr(std::move(thr)) {};
  ~threadguard() { if (thr.joinable()) thr.join(); }
};
