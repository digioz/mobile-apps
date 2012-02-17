//
//  ViewController.m
//  Tip Calculator
//
//  Created by Pedram Soheil on 2/3/12.
//  Copyright (c) 2012 Google Voice. All rights reserved.
//

#import "ViewController.h"

@implementation ViewController

@synthesize txtBillAmount;
@synthesize txtTipPercent;
@synthesize lblTipCalculated;

- (IBAction) calculateTip
{
    [txtTipPercent resignFirstResponder];
    
    float billamount = [[txtBillAmount text] floatValue];
    float tippercent = [[txtTipPercent text] floatValue];
    
    tippercent = tippercent / 100;
    
    float calculatedtip = billamount * tippercent;
    
    lblTipCalculated.text = [NSString stringWithFormat: @"Tip Amout Is: %.2f", calculatedtip];
}

- (IBAction) resetForm
{
    txtBillAmount.text = @"";
    txtTipPercent.text = @"";
    lblTipCalculated.text = @"";
}

- (IBAction) makeKeyboardGoAway
{
    [txtTipPercent resignFirstResponder];
}

- (BOOL) textFieldShouldReturn:(UITextField *)textField
{
    [textField resignFirstResponder];
    return YES;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    txtTipPercent.keyboardType = UIKeyboardTypeNumbersAndPunctuation;
    txtBillAmount.keyboardType = UIKeyboardTypeNumbersAndPunctuation;
    
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated
{
	[super viewWillDisappear:animated];
}

- (void)viewDidDisappear:(BOOL)animated
{
	[super viewDidDisappear:animated];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
