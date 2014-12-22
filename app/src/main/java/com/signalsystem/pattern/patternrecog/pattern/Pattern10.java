package com.signalsystem.pattern.patternrecog.pattern;

import com.signalsystem.pattern.patternrecog.R;

/**
 * Created by kim-donggi on 14. 12. 21..
 */
public class Pattern10 extends PatternSampling {
    public static final String TAG = "Pattern10";

    @Override
    public void init() {
        // 모든 샘플 이미지는 사이즈가 같아야 한다.
        sample_images = new int[] {R.drawable.pattern10_1,
                R.drawable.pattern10_2,
                R.drawable.pattern10_3,
                R.drawable.pattern10_4,
                R.drawable.pattern10_5,
                R.drawable.pattern10_6,
                R.drawable.pattern10_7,
                R.drawable.pattern10_8,
                R.drawable.pattern10_9,
                R.drawable.pattern10_10};
        sample_coeff = new Double[sample_images.length][];
        center = new Double[]{1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 1.16299645259375E8, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 620526.032538878, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1.810029024983111E7, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1448034.454807348, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 1830662.9170881205, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2032738.5178115119, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 2973959.843366545, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 3461554.7629831927, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 1307822.5709080575, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 3689969.688454432, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 832374.4476442363, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1393897.694588251, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 1257493.2339132903, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 993339.1049403962, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 886712.0943854753, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 1016707.453125, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 420976.856070056, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 886712.0943854749, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 993339.1049403958, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1257493.233913295, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 1393897.6945882458, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 832374.4476442401, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 3689969.688454438, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 1307822.570908055, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 3461554.762983215, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2973959.84336652, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 2032738.517811527, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1830662.9170881254, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1448034.4548073453, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 1.8100290249831058E7, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794, 620526.0325388794};
        radius = 8.368846303578572E8;
        super.init();
    }
}