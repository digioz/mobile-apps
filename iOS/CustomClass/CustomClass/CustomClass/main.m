//
//  main.m
//  CustomClass
//
//  Created by Pedram Soheil on 2/2/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Dog.h"

int main (int argc, const char * argv[])
{
    Dog *a = [[Dog alloc] init];
    [a setName:@"Fido"];
    Dog *b = [[Dog alloc] init];
    [b setName:@"Lucky"];
    
    [a bark];
    [b bark];
    
    //[a autorelease];
    //[b autorelease];
    
    // [a release];
    // [b release];
    
    return 0;
}

