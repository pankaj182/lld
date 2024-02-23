### What?
- The intent of a rate limiter is to control the rate at which requests or actions are allowed to occur within a system or API. 
- It sets limits on the number of requests or actions that can be made within a specific time frame
- ensures fair allocation, and mitigates the risk of performance degradation or abuse.

### Why?
- To Prevent Denial Of Service 
- To Prevent Brute Force Attacks 
- To Prevent Resource starvation 
- To Prevent Cascading Failures

### Why not auto-scale?
- Auto-scaling might be costly,
- in case of DDOS(bot requests), auto-scaling won’t be a viable solution since the newly provisioned instances will also be victims of DDOS. 

### Functional Requirements of a Rate Limiter
- Flexible Rate Limiting Rules
- Customizable Response Handling
- Storage and Retrieval of Rate-Limit Data
- Proper Error Handling
  - returning 429
- Expose an endpoint
  - to check their current rate limit status.
  - #requests allowed within time frame(ie rate limiting rules)
- Set headers
  - #requests made so far in a time frame
  - time frame when it is reset

### Non Functional Requirements
- highly available and scalable API.
- The API should be secure and protected against malicious attacks.
- The API should be easy to integrate with existing systems.
- low latency provided by the rate limiter

### Rate Limiter Position
- client side
  - client proactively manage their own request rate
  - Reduced Network Traffic, Immediate Feedback & client autonomy
  - But client is an unreliable place to enforce rate limiting
- server side
  - protect server resources, maintain fairness across clients, or when clients cannot be fully trusted to adhere to rate limits.
  - But Transmitting rate-limited requests to the server can lead to more network traffic, which can put a heavier load on the network
- middleware
 - middleware components or API gateways that intercept and process incoming requests before forwarding them to the server.
 - If the middleware rate limiter becomes a single point of failure, it can impact the overall system’s availability and reliability.

### Algorithms for Rate Limiter
#### Token Bucket
- The token bucket algorithm is a popular method used in rate limiting to control the rate of requests or actions. 
- It operates based on the concept of a token bucket, which is a metaphorical bucket holding tokens.
- a bucket is initially filled with a predetermined number of tokens. 
- Each token represents permission to make a request or perform an action. 
- When a request is made, a token is consumed from the bucket. 
- If the bucket is empty, meaning there are no more tokens available, further requests are either blocked or delayed until more tokens are added to the bucket.
- Tokens are added to the bucket at a fixed rate over time, known as the token generation rate or refill rate.

#### Sliding Window Counter
- Determine the desired duration of the sliding window. For example, a sliding window of 10 minutes will consider only log events from the past 10 minutes.
- Set up a queue, to store log events within the sliding window. 
- The size of the data structure should accommodate the maximum number of log events that can occur within the time window.
