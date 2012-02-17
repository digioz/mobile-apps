//
//  main.m
//  simple
//
//  Created by Pedram Soheil on 1/29/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <Foundation/Foundation.h>

int main (int argc, const char * argv[])
{

    @autoreleasepool {
        
        // insert code here...
        NSLog(@"Hello, World!");
        
        int temperature = 75;
        NSString *city = @"Ventura";
        NSDate *today = [NSDate date];
        
        NSLog(@"On %@, the weather in %@ is %d degrees",today,city,temperature);
    }
    return 0;
}

