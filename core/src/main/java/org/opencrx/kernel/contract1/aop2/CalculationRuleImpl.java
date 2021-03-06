/*
 * ====================================================================
 * Project:     openCRX/Core, http://www.opencrx.org/
 * Description: CalculationRuleImpl
 * Owner:       CRIXP AG, Switzerland, http://www.crixp.com
 * ====================================================================
 *
 * This software is published under the BSD license
 * as listed below.
 * 
 * Copyright (c) 2004-2019, CRIXP Corp., Switzerland
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions 
 * are met:
 * 
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in
 * the documentation and/or other materials provided with the
 * distribution.
 * 
 * * Neither the name of CRIXP Corp. nor the names of the contributors
 * to openCRX may be used to endorse or promote products derived
 * from this software without specific prior written permission
 * 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * ------------------
 * 
 * This product includes software developed by the Apache Software
 * Foundation (http://www.apache.org/).
 * 
 * This product includes software developed by contributors to
 * openMDX (http://www.openmdx.org/)
 */
package org.opencrx.kernel.contract1.aop2;

import org.opencrx.kernel.backend.Contracts;
import org.opencrx.kernel.contract1.jmi1.GetContractAmountsResult;
import org.opencrx.kernel.contract1.jmi1.GetPositionAmountsResult;
import org.openmdx.base.accessor.jmi.cci.JmiServiceException;
import org.openmdx.base.aop2.AbstractObject;
import org.openmdx.base.exception.ServiceException;

/**
 * CalculationRuleImpl
 * 
 */
public class CalculationRuleImpl
	<S extends org.opencrx.kernel.contract1.jmi1.CalculationRule,N extends org.opencrx.kernel.contract1.cci2.CalculationRule,C extends Void>
	extends AbstractObject<S,N,C> {

    public CalculationRuleImpl(
        S same,
        N next
    ) {
    	super(same, next);
    }

    /**
     * Get position amounts.
     * 
     * @param params
     * @return
     */
    public org.opencrx.kernel.contract1.jmi1.GetPositionAmountsResult getPositionAmounts(
        org.opencrx.kernel.contract1.jmi1.GetPositionAmountsParams params
    ) {
        try {
            GetPositionAmountsResult result = Contracts.getInstance().getPositionAmounts(
                this.sameObject(),
                params.getPosition(),
                params.getOverridePricePerUnit(),
                params.getOverrideQuantity(),
                params.getOverrideUomScaleFactor(),
                params.getOverrideDiscount(),
                params.isOverrideDiscountIsPercentage(),
                params.getOverrideDiscountCalculationType(),
                params.getOverrideSalesTaxRate()
            );
            return result;
        } catch(ServiceException e) {
            throw new JmiServiceException(e);
        }
    }

    /**
     * Get contract amounts.
     * 
     * @param params
     * @return
     */
    public org.opencrx.kernel.contract1.jmi1.GetContractAmountsResult getContractAmounts(
        org.opencrx.kernel.contract1.jmi1.GetContractAmountsParams params
    ) {
        try {
            GetContractAmountsResult result = Contracts.getInstance().getContractAmounts(
                this.sameObject(),
                params.getContract(),
                params.getLineItemNumber(),
                params.getPositionBaseAmount(),
                params.getPositionDiscountAmount(),
                params.getPositionTaxAmount(),
                params.getPositionAmount(),
                params.getSalesCommission(),
                params.getSalesCommissionIsPercentage()
            );
            return result;
        } catch(ServiceException e) {
            throw new JmiServiceException(e);
        }
    }
   
}
