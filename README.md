## 📊 JMeter Benchmark — 1 Million Requests

We stress-tested the simulator with **1,000,000 requests** using **Apache JMeter (TCP Sampler)**.  
Below are the results for each threading model.

### 🔹 Single Threading
![Single Thread JMeter](https://github.com/user-attachments/assets/7c33e19a-97d9-49bc-a7d0-278b32d72f2f)

- **Samples:** 1,000,000  
- **Average Response Time:** 10 ms  
- **Median:** 3 ms  
- **Max:** 837 ms  
- **Error %:** 37.58%  
- **Throughput:** 3836.2/sec  
---

### 🔹 Multi Threading
![Multi Thread JMeter](https://github.com/user-attachments/assets/80e2ba59-4008-4c32-8f62-9e66102b0952)

- **Samples:** 1,000,000  
- **Average Response Time:** 39 ms  
- **Median:** 4 ms  
- **Max:** 2145 ms  
- **Error %:** 75.59%  
- **Throughput:** 4421.5/sec  


---

### 🔹 Thread Pooling
![Thread Pool JMeter](https://github.com/user-attachments/assets/fef5b891-9e88-4e2a-8c78-740d1121db81)

- **Samples:** 1,000,000  
- **Average Response Time:** 4 ms  
- **Median:** 2 ms  
- **Max:** 390 ms  
- **Error %:** 6.81%  
- **Throughput:** 4842.2/sec  

---


### 📈 Comparison Table

| Mode            | Avg (ms) | Median (ms) | Max (ms) | Error % | Throughput (req/sec) |
|-----------------|----------|-------------|----------|---------|-----------------------|
| **Single**      | 39       | 4           | 2145     | 37.58%  | 4421.5                |
| **Multi**       | 10       | 3           | 837      | 75.59%  | 3836.2                |
| **Thread Pool** | 4        | 2           | 390      | 6.81%   | 4842.2                |

---

### 🔎 Insights
- **Single Threading** → Surprisingly performed better than multi-threading. Although slower on average, its error rate (37%) was much lower.  
- **Multi Threading** → Struggled badly (~75% error rate) because the server was creating a **new thread for every request**, which led to massive overhead and instability.  
- **Thread Pooling** → Clear winner: **lowest error %, highest throughput, and lowest latency**. Reusing threads via a pool prevented the overhead seen in multi-threading.

---

