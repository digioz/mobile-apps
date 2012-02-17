//
//  ViewController.h
//  ControlsTest1
//
//  Created by Pedram Soheil on 2/6/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController {
    IBOutlet UISegmentedControl *colorChooser;
    IBOutlet UITextView *sampleText;
}

@property (nonatomic, retain) UISegmentedControl *colorChooser;
@property (nonatomic, retain) UITextView *sampleText;

- (IBAction) colorChanged;

@end
