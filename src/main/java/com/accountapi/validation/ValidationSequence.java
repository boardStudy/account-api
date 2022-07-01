package com.accountapi.validation;

import com.accountapi.validation.ValidationGroups.NotNullGroup;
import com.accountapi.validation.ValidationGroups.PatternCheckGroup;
import com.accountapi.validation.ValidationGroups.SizeCheckGroup;
import com.accountapi.validation.ValidationGroups.EmailCheckGroup;

import javax.validation.GroupSequence;

@GroupSequence({NotNullGroup.class, SizeCheckGroup.class, PatternCheckGroup.class, EmailCheckGroup.class})
public interface ValidationSequence {
}
