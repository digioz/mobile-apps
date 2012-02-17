//
//  ViewController.h
//  DataSources
//
//  Created by Pedram Soheil on 2/10/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController 
<UIPickerViewDelegate, UIPickerViewDataSource> {
    NSArray *moods;
    IBOutlet UIPickerView *moodPicker;
}

@property (nonatomic, retain) UIPickerView *moodPicker;

@end
