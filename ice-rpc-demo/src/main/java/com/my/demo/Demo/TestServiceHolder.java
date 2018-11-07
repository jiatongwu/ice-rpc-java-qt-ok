// **********************************************************************
//
// Copyright (c) 2003-2017 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.4
//
// <auto-generated>
//
// Generated from file `demo.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.my.demo.Demo;

public final class TestServiceHolder extends Ice.ObjectHolderBase<TestService>
{
    public
    TestServiceHolder()
    {
    }

    public
    TestServiceHolder(TestService value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof TestService)
        {
            value = (TestService)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _TestServiceDisp.ice_staticId();
    }
}
