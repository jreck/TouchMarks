//
//  View.m
//  LatencyTest
//
//  Created by Chuo-Ling Chang on 10/7/13.
//  Copyright (c) 2013 Chuo-Ling Chang. All rights reserved.
//

#import "View.h"

@implementation View

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        _color = 0.0f;
    }
    return self;
}

- (void)drawRect:(CGRect)rect
{
    glClearColor(_color, _color, _color, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);
}

@end
