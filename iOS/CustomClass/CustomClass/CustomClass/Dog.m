//
//  Dog.m
//  CustomClass
//
//  Created by Pedram Soheil on 2/2/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import "Dog.h"

@implementation Dog
- (void) bark {
    NSLog(@"Woof, says %@", name);
}

- (void) setName:(NSString *)n {
    name = n;
}

- (void) dealloc {
    NSLog(@"Dog Object %@ is being destroyed", name);
    // [super dealloc];
}
@end
