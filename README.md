
# Twitter automation

Automated daily crypto updates on Twitter. 

## Inspiration for this project

I was always interested in building software that could work by itself. Automation.

As I'm always looking for different investments and higher capital returns, 
I decided to build a Twitter bot capable of creating new tweets
ifself everyday with crypto info.

Bitcoin was chosen in the first place. 
New versions might have different options.
## Installation

1. Clone the following link locally

```bash
  git clone https://github.com/DanielDomingueti/btc-twitter-bot.git
  cd btc-twitter-project
```
2. Create a Twitter account

```bash
  https://twitter.com/i/flow/signup
```

3. Get your account KEY to create requests following the link below
```bash
  https://developer.twitter.com/en/docs/twitter-api/getting-started/getting-access-to-the-twitter-api
```

4. Create the file twitter4j.properties (src/main/resources) and insert the keys as following
   - oauth.consumerKey=API KEY from Twitter
   - oauth.consumerSecret=API KEY SECRET
   - oauth.accessToken=ACCESS TOKEN
   - oauth.accessTokenSecret=ACCESS TOKEN SECRET
   
5. Run the Spring application and the cron will be execute at a given moment.

6. You can also make a request in this URL if you're willing to create a tweet instantly.
```bash
  POST http://localhost:8080/messari/post/
```
7. But if you just want to fetch data, here you go
```bash
  GET http://localhost:8080/messari/get/{cryptoSymbol e.g. BTC}
```

## Technologies used

This project was built with these technologies:

- Spring Boot
- Java 11
- Maven
- Twitter4J library
- Messari API
- AWS EC2 for deployment


## How does it work?

Brief explanation about the project's functionalities

1. Its core is based on a CRON method. Everyday at 10 a.m. and 22 p.m. 
the system make a request at ```/messari/get/{cryptoSymbol}``` and grab BTC, ETH and SOL's current price.

2. The service ```InsertTweetService``` process it and call the function execute() 
in ```PostTweet class``` to post a tweet.

3. You can easily change the cron's time in ```PostTweet```

4. If needed, you can insert a tweet at the current moment at ```/messari/post```
