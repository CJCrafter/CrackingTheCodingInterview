## Question
You have 20 bottles of pills. 19 bottles have 1.0 gram pills, but one has 
pills of weight 1.1 grams. Given a scale that provides an exact measurement, 
how would you find the heavy bottle? You can only use the scale once.

## Process
Since we can only use the scale once, we need to use 19 or 20 of the bottles 
on the scale at the same time, and we need some method to identify which bottle
is which

If we put 1 pill from all 20 bottles onto the scale, the scale will read 20.1 grams  
If we put 1 pill from 19 of the 20 bottles onto the scale, the scale will read either 19.0 or 19.1 grams  
If we put 2 pills from all 20 bottles onto the scale, the scale will read 40.2

So we want to have piles of pills on the scale where each pile is of a unique
amount and all of the pills in the pile comes from one bottle.

Following that rule, there should be 210 pills on the scale. The weight will be
[210.1, 212.0]. 

Next we need to identify exactly how many heavy pills are on the scale. We can do
that by getting the weight (x) the scale reads and subtracting 210.0 (Which is the
weight, in grams, of all of the pills if every single pill weighed 1 gram) then 
multiplying that number by 10.

For example, if the weight is 211.7, then `(211.7 - 210.0) * 10 = 17`, so bottle 17
had the weighted pills.

## Answer
1. Assign a number to each bottle, 1 through 20
2. For each bottle, place it's number of pills on the scale (They don't 
need to be sorted when placed on the scale)
3. Find the number of weighted pills by using `(x - 210.0) * 10` where x is the weight, in grams, that the scale reads
4. The pill is in the bottle with the number found from the above equation