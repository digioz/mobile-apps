//
//  Dog.h
//  CustomClass
//
//  Created by Pedram Soheil on 2/2/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Dog : NSObject {
    // ivars
    int age;
    NSString *name;
}

// public methods
- (void) bark;
- (void) setName: (NSString *)n;

@end
