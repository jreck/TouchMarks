//
//  ViewController.m
//  LatencyTest
//
//  Created by Chuo-Ling Chang on 10/1/13.
//  Copyright (c) 2013 Chuo-Ling Chang. All rights reserved.
//

#import "ViewController.h"
#import "View.h"

@interface ViewController ()
{
    View *view;
}
@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    view = [[View alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    view.context = [[EAGLContext alloc] initWithAPI:kEAGLRenderingAPIOpenGLES2];
    view.drawableColorFormat = GLKViewDrawableColorFormatRGBA8888;
    
    self.preferredFramesPerSecond = 60;
    self.view = view;
}

- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    view.color = 1.0f;
    [super touchesBegan:touches withEvent:event];
}

- (void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    view.color = 0.0f;
    [super touchesEnded:touches withEvent:event];
}

@end
