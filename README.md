## 📊 JMeter Benchmark — 1 Million Requests

We stress-tested the simulator with **1,000,000 requests** using **Apache JMeter (TCP Sampler)**.  
Below are the results for each threading model.

### 🔹 Single Threading
![Single Thread JMeter]()

- **Samples:** 1,000,000  
- **Average Response Time:** 39 ms  
- **Median:** 4 ms  
- **Max:** 2145 ms  
- **Error %:** 75.59%  
- **Throughput:** 4421.5/sec  

---

### 🔹 Multi Threading
![Multi Thread JMeter](<img width="1527" height="817" alt="Screenshot 2025-08-15 175731" src="https://github.com/user-attachments/assets/80e2ba59-4008-4c32-8f62-9e66102b0952" />
)

- **Samples:** 1,000,000  
- **Average Response Time:** 10 ms  
- **Median:** 3 ms  
- **Max:** 837 ms  
- **Error %:** 37.58%  
- **Throughput:** 3836.2/sec  

---

### 🔹 Thread Pooling
![Thread Pool JMeter](docs/jmeter-pool.png)

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
| **Single**      | 39       | 4           | 2145     | 75.59%  | 4421.5                |
| **Multi**       | 10       | 3           | 837      | 37.58%  | 3836.2                |
| **Thread Pool** | 4        | 2           | 390      | 6.81%   | 4842.2                |

---

### 🔎 Insights
- **Single Threading** → Couldn’t scale, very high error rate.  
- **Multi Threading** → Faster but unstable due to massive thread creation (high error %).  
- **Thread Pooling** → Best performer: **lowest error %, highest throughput, lowest latency**.  

---

