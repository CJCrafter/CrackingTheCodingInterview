## Question
You have a basketball hoop and someone says that you can play one of 2 games.

Game 1: You get one shot to make the hoop  
Game 2: You get three shots and you have to make two of three shots

If `p` is the probability of making a particular shot, for which values of `p` 
should you pick one game or the other

## Process
Given the probability in the problem, instead of proving logic with concrete information,
we have to look at statistical likeliness.

Mark Rober talked about a problem like this before. He mentioned if you were in a 1v1
with a professional basketball player, you should always go best to 1 instead of 
best to 7. This is because the more skilled player is significantly better than you, and
you can really only win by luck. You are more likely to get lucky once then 4 times.

So we know that if you have a higher chance of winning, you should pick the the second game. 

In game 2, we need at least a 66% success rate to be statistically likely to win, while in game 1
we need a 100% success rate to be statistically likely to win. It's easier to think of probability as your
skill in this situation. When your "skill" is higher, choose the game where you'll do better on average (Which
is the game where you get more chances). When your skill is lower, chose the game where your higher skill 
opponent will do worse on average (Which is the game they get less chances).

## Answer
When your probability of making a shot is [0, 66) percent, you should choose game 1. When your probability
of making a shot is [66, 100] percent, you should choose game 2.