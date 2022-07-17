
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

4. Insert your KEY into the file application.properties

5. Run the Spring application and the cron will be execute at a given moment.

6. You can also make a request in this URL if you're willing to create a tweet instantly.
```bash
  POST http://localhost:8080/tweet/post/now
```

## Technologies used

This project was built with these technologies:

- Spring Boot
- Java 11
- Maven
- Twitter4J library
- Messari API


## How does it work?

Brief explanation about the project's functionalities

1. Its core is based on a CRON method. Everyday at a given hour 
the system make a request at ```MESSARI URL``` and grab Bitcoin's current price.

2. The service ```SERVICE NAME``` process it and create another request 
at ```TWITTER API URL``` to post a tweet.

3. You can easily change the cron's time in ```CRON CLASS```

4. If needed, you can insert a tweet at the current moment at ```MANUAL TWEET URL```
