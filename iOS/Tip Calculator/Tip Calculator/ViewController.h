//
//  ViewController.h
//  Tip Calculator
//
//  Created by Pedram Soheil on 2/3/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController {
    IBOutlet UITextField *txtBillAmount;
    IBOutlet UITextField *txtTipPercent;
    IBOutlet UILabel *lblTipCalculated;
}

@property (nonatomic, retain) IBOutlet UITextField *txtBillAmount;
@property (nonatomic, retain) IBOutlet UITextField *txtTipPercent;
@property (nonatomic, retain) IBOutlet UILabel *lblTipCalculated;

- (IBAction) calculateTip;
- (IBAction) makeKeyboardGoAway;
- (IBAction) resetForm;

@end
