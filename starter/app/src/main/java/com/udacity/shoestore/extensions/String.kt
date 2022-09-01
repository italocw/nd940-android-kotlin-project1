package com.udacity.shoestore.extensions

import com.udacity.shoestore.RegexPattern.EMAIL

fun String.isValidEmail() = matches(Regex(EMAIL))