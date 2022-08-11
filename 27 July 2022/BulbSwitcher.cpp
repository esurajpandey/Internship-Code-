/*
    Bulb Switcher
    There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

    On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
*/
#include<iostream>
#include<math.h>
using namespace std;
int main(){
	int n;
	cout<<"Enter number of rounds:";
	cin>>n;
	cout<<"Total bulb which is switched on at end: "<<(int)sqrt(n);
}
