/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openbidder.exchange.doubleclick;

import com.google.openbidder.api.platform.Exchange;

/**
 * Constants for DoubleClick Ad Exchange.
 */
public final class DoubleClickConstants {

  /**
   * DoubleClick's implementation of {@link Exchange}.
   */
  public static final Exchange EXCHANGE = DoubleClickExchange.INSTANCE;

  /**
   * Unknown price value for %%WINNING_PRICE%%.
   */
  public static final String PRICE_UNKNOWN = "UNKNOWN";

  /**
   * Key for creative attribute RichMediaCapabilityFlash.
   */
  public static final int CREATIVE_FLASH = 34;

  /**
   * Key for creative attribute RichMediaCapabilityNonFlash.
   */
  public static final int CREATIVE_NON_FLASH = 50;

  /**
   * Key for creative attribute RichMediaCapabilitySSL.
   */
  public static final int CREATIVE_SSL = 47;

  /**
   * Key for creative attribute RichMediaCapabilityNonSSL.
   */
  public static final int CREATIVE_NON_SSL = 48;

  private DoubleClickConstants () {
  }
}
