/*
 * The MIT License
 *
 * Copyright (c) 2018 Richard Capraro
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.capraro.kalidation.constraints.validator

import com.capraro.kalidation.constraints.annotation.CsNegative
import java.math.BigDecimal
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


/**
 * CharSequence negative number validator.
 * @author Richard Capraro
 * @since 1.2.6
 */
class CsNegativeValidator : ConstraintValidator<CsNegative, CharSequence> {

    override fun isValid(value: CharSequence?, context: ConstraintValidatorContext): Boolean = value?.let {
        return try {
            val number = BigDecimal(value.toString())
            number.signum() < 0
        } catch (nfe: NumberFormatException) {
            false
        }
    } ?: true
}