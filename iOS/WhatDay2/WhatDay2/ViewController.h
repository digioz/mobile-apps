//
//  ViewController.h
//  WhatDay2
//
//  Created by Pedram Soheil on 2/10/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController {
    IBOutlet UIDatePicker *datePicker1;
}

@property (nonatomic, retain) UIDatePicker *datePicker1;

- (IBAction) displayDay;

@end
