package com.facebook.react.views.textinput;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.room.FtsOptions;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextAttributeProps;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextTransform;
import com.facebook.yoga.YogaConstants;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

@ReactModule(name = "AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final int AUTOCAPITALIZE_FLAGS = 28672;
    private static final int BLUR_TEXT_INPUT = 2;
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final int KEYBOARD_TYPE_FLAGS = 12339;
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    private static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    private static final int SET_TEXT_AND_SELECTION = 4;
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    private static final int UNSET = -1;

    public String getName() {
        return REACT_CLASS;
    }

    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        return reactEditText;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topSubmitEditing", MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put(ReactTextInputEvent.EVENT_NAME, MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onBlur", "captured", "onBlurCapture"))).put(ReactTextInputKeyPressEvent.EVENT_NAME, MapBuilder.m138of("phasedRegistrationNames", MapBuilder.m139of("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).build();
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.m138of("registrationName", "onScroll")).build();
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.m139of("focusTextInput", 1, "blurTextInput", 2);
    }

    public void receiveCommand(ReactEditText reactEditText, int i, @Nullable ReadableArray readableArray) {
        switch (i) {
            case 1:
                receiveCommand(reactEditText, "focus", readableArray);
                return;
            case 2:
                receiveCommand(reactEditText, "blur", readableArray);
                return;
            case 3:
                receiveCommand(reactEditText, "setMostRecentEventCount", readableArray);
                return;
            case 4:
                receiveCommand(reactEditText, "setTextAndSelection", readableArray);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.textinput.ReactEditText r7, java.lang.String r8, @androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r9) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            r1 = 1
            r2 = 2
            r3 = 3
            r4 = 0
            r5 = -1
            switch(r0) {
                case -1699362314: goto L_0x003f;
                case 3027047: goto L_0x0035;
                case 97604824: goto L_0x002b;
                case 1427010500: goto L_0x0021;
                case 1690703013: goto L_0x0017;
                case 1813033077: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "setMostRecentEventCount"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 4
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "focusTextInput"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 1
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "setTextAndSelection"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 5
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "focus"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 0
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "blur"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 2
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "blurTextInput"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0049
            r8 = 3
            goto L_0x004a
        L_0x0049:
            r8 = -1
        L_0x004a:
            switch(r8) {
                case 0: goto L_0x007a;
                case 1: goto L_0x007a;
                case 2: goto L_0x0076;
                case 3: goto L_0x0076;
                case 4: goto L_0x006e;
                case 5: goto L_0x004e;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x007d
        L_0x004e:
            int r8 = r9.getInt(r4)
            r7.setMostRecentEventCount(r8)
            if (r8 == r5) goto L_0x007d
            java.lang.String r0 = r9.getString(r1)
            int r1 = r9.getInt(r2)
            int r9 = r9.getInt(r3)
            if (r9 != r5) goto L_0x0066
            r9 = r1
        L_0x0066:
            com.facebook.react.views.text.ReactTextUpdate r8 = r6.getReactTextUpdate(r0, r8, r1, r9)
            r7.maybeSetTextFromJS(r8)
            goto L_0x007d
        L_0x006e:
            int r8 = r9.getInt(r4)
            r7.setMostRecentEventCount(r8)
            goto L_0x007d
        L_0x0076:
            r7.clearFocusFromJS()
            goto L_0x007d
        L_0x007a:
            r7.requestFocusFromJS()
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.receiveCommand(com.facebook.react.views.textinput.ReactEditText, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    private ReactTextUpdate getReactTextUpdate(String str, int i, int i2, int i3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = str;
        spannableStringBuilder.append(TextTransform.apply(str, TextTransform.UNSET));
        return new ReactTextUpdate(spannableStringBuilder, i, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, i2, i3);
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            int paddingLeft = (int) reactTextUpdate.getPaddingLeft();
            int paddingTop = (int) reactTextUpdate.getPaddingTop();
            int paddingRight = (int) reactTextUpdate.getPaddingRight();
            int paddingBottom = (int) reactTextUpdate.getPaddingBottom();
            if (!(paddingLeft == -1 && paddingTop == -1 && paddingRight == -1 && paddingBottom == -1)) {
                if (paddingLeft == -1) {
                    paddingLeft = reactEditText.getPaddingLeft();
                }
                if (paddingTop == -1) {
                    paddingTop = reactEditText.getPaddingTop();
                }
                if (paddingRight == -1) {
                    paddingRight = reactEditText.getPaddingRight();
                }
                if (paddingBottom == -1) {
                    paddingBottom = reactEditText.getPaddingBottom();
                }
                reactEditText.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            if (reactTextUpdate.containsImages()) {
                TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.getText(), reactEditText);
            }
            reactEditText.maybeSetTextFromState(reactTextUpdate);
            if (reactTextUpdate.getSelectionStart() != -1 && reactTextUpdate.getSelectionEnd() != -1) {
                reactEditText.setSelection(reactTextUpdate.getSelectionStart(), reactTextUpdate.getSelectionEnd());
            }
        }
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f) {
        reactEditText.setFontSize(f);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setFontFamily(str);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f) {
        reactEditText.setMaxFontSizeMultiplier(f);
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setFontWeight(str);
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setFontStyle(str);
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactEditText reactEditText, boolean z) {
        reactEditText.setIncludeFontPadding(z);
    }

    @ReactProp(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, @Nullable String str) {
        int i;
        if ("no".equals(str)) {
            i = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i = 8;
        } else if ("yes".equals(str)) {
            i = 1;
        } else {
            i = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(reactEditText, i);
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setImportantForAutofill(i);
        }
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setAutofillHints(strArr);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(reactEditText));
        } else {
            reactEditText.setSelectionWatcher((SelectionWatcher) null);
        }
    }

    @ReactProp(name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, @Nullable Boolean bool) {
        reactEditText.setBlurOnSubmit(bool);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(reactEditText));
        } else {
            reactEditText.setContentSizeWatcher((ContentSizeWatcher) null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(reactEditText));
        } else {
            reactEditText.setScrollWatcher((ScrollWatcher) null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z) {
        reactEditText.setOnKeyPress(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f) {
        reactEditText.setLetterSpacingPt(f);
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z) {
        reactEditText.setAllowFontScaling(z);
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
        setCursorColor(reactEditText, num);
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, @Nullable Integer num) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(reactEditText);
            if (i != 0) {
                Drawable drawable = ContextCompat.getDrawable(reactEditText.getContext(), i);
                if (num != null) {
                    drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                }
                Drawable[] drawableArr = {drawable, drawable};
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(reactEditText);
                Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                declaredField3.setAccessible(true);
                declaredField3.set(obj, drawableArr);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    @ReactProp(defaultInt = 0, name = "mostRecentEventCount")
    public void setMostRecentEventCount(ReactEditText reactEditText, int i) {
        reactEditText.setMostRecentEventCount(i);
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z) {
        reactEditText.setCursorVisible(!z);
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, final boolean z) {
        reactEditText.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return z;
            }
        });
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectAllOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setTextColor(DefaultStyleValuesUtil.getDefaultTextColor(reactEditText.getContext()));
        } else {
            reactEditText.setTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, @Nullable Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e) {
                FLog.m63e(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", (Throwable) e);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, @Nullable String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if ("left".equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if ("right".equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if (TtmlNode.CENTER.equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if (ViewProps.TOP.equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if (ViewProps.BOTTOM.equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if (TtmlNode.CENTER.equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
        }
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i) {
        reactEditText.setCompoundDrawablePadding(i);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i) {
        reactEditText.setLines(i);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, @Nullable Integer num) {
        InputFilter[] filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < filters.length; i++) {
                    if (!(filters[i] instanceof InputFilter.LengthFilter)) {
                        linkedList.add(filters[i]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof InputFilter.LengthFilter) {
                    filters[i2] = new InputFilter.LengthFilter(num.intValue());
                    z = true;
                }
            }
            if (!z) {
                inputFilterArr = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(num.intValue());
            } else {
                inputFilterArr = filters;
            }
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(name = "autoCompleteType")
    public void setTextContentType(ReactEditText reactEditText, @Nullable String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
        } else if ("username".equals(str)) {
            setAutofillHints(reactEditText, "username");
        } else if ("password".equals(str)) {
            setAutofillHints(reactEditText, "password");
        } else if ("email".equals(str)) {
            setAutofillHints(reactEditText, "emailAddress");
        } else if ("name".equals(str)) {
            setAutofillHints(reactEditText, "name");
        } else if ("tel".equals(str)) {
            setAutofillHints(reactEditText, "phone");
        } else if ("street-address".equals(str)) {
            setAutofillHints(reactEditText, "postalAddress");
        } else if ("postal-code".equals(str)) {
            setAutofillHints(reactEditText, "postalCode");
        } else if ("cc-number".equals(str)) {
            setAutofillHints(reactEditText, "creditCardNumber");
        } else if ("cc-csc".equals(str)) {
            setAutofillHints(reactEditText, "creditCardSecurityCode");
        } else if ("cc-exp".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationDate");
        } else if ("cc-exp-month".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationMonth");
        } else if ("cc-exp-year".equals(str)) {
            setAutofillHints(reactEditText, "creditCardExpirationYear");
        } else if ("off".equals(str)) {
            setImportantForAutofill(reactEditText, 2);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid autoCompleteType: " + str);
        }
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, @Nullable Boolean bool) {
        updateStagedInputTypeFlag(reactEditText, 557056, bool != null ? bool.booleanValue() ? 32768 : 524288 : 0);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        int i = 131072;
        int i2 = z ? 0 : 131072;
        if (!z) {
            i = 0;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 144;
        if (z) {
            i = 128;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, Dynamic dynamic) {
        int i = 16384;
        if (dynamic.getType() == ReadableType.Number) {
            i = dynamic.asInt();
        } else if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.equals(ViewProps.NONE)) {
                i = 0;
            } else if (asString.equals("characters")) {
                i = 4096;
            } else if (asString.equals("words")) {
                i = 8192;
            } else {
                boolean equals = asString.equals("sentences");
            }
        }
        updateStagedInputTypeFlag(reactEditText, AUTOCAPITALIZE_FLAGS, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "keyboardType")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setKeyboardType(com.facebook.react.views.textinput.ReactEditText r4, @androidx.annotation.Nullable java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "numeric"
            boolean r0 = r0.equalsIgnoreCase(r5)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            r2 = 12290(0x3002, float:1.7222E-41)
            r5 = 12290(0x3002, float:1.7222E-41)
        L_0x000e:
            r2 = 0
            goto L_0x005a
        L_0x0010:
            java.lang.String r0 = "number-pad"
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x001b
            r2 = 2
            r5 = 2
            goto L_0x000e
        L_0x001b:
            java.lang.String r0 = "decimal-pad"
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x0028
            r2 = 8194(0x2002, float:1.1482E-41)
            r5 = 8194(0x2002, float:1.1482E-41)
            goto L_0x000e
        L_0x0028:
            java.lang.String r0 = "email-address"
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x0035
            r2 = 33
            r5 = 33
            goto L_0x000e
        L_0x0035:
            java.lang.String r0 = "phone-pad"
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x0040
            r2 = 3
            r5 = 3
            goto L_0x000e
        L_0x0040:
            java.lang.String r0 = "visible-password"
            boolean r5 = r0.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x004e
            r2 = 144(0x90, float:2.02E-43)
            r5 = 144(0x90, float:2.02E-43)
            goto L_0x000e
        L_0x004e:
            int r5 = r4.getStagedInputType()
            r5 = r5 & 28672(0x7000, float:4.0178E-41)
            if (r5 == 0) goto L_0x0058
            r5 = 1
            goto L_0x005a
        L_0x0058:
            r5 = 1
            goto L_0x000e
        L_0x005a:
            if (r2 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r1 = 12339(0x3033, float:1.729E-41)
        L_0x005f:
            updateStagedInputTypeFlag(r4, r1, r5)
            checkPasswordType(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.setKeyboardType(com.facebook.react.views.textinput.ReactEditText, java.lang.String):void");
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z) {
        reactEditText.setDisableFullscreenUI(z);
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i, float f) {
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        if (i == 0) {
            reactEditText.setBorderRadius(f);
        } else {
            reactEditText.setBorderRadius(f, i - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setBorderStyle(str);
    }

    @ReactProp(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setShowSoftInputOnFocus(z);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i, float f) {
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        reactEditText.setBorderWidth(SPACING_TYPES[i], f);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i, Integer num) {
        float f = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        reactEditText.setBorderColor(SPACING_TYPES[i], intValue, f);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction(reactEditText);
        reactEditText.maybeUpdateTypeface();
        reactEditText.commitStagedInputType();
    }

    private static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    private static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i, int i2) {
        reactEditText.setStagedInputType(((~i) & reactEditText.getStagedInputType()) | i2);
    }

    private class ReactTextInputTextWatcher implements TextWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private String mPreviousText = null;

        public void afterTextChanged(Editable editable) {
        }

        public ReactTextInputTextWatcher(ReactContext reactContext, ReactEditText reactEditText) {
            this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
            this.mEditText = reactEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreviousText = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            JavaOnlyArray javaOnlyArray;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            if (!this.mEditText.mDisableTextDiffing) {
                if (i7 != 0 || i6 != 0) {
                    Assertions.assertNotNull(this.mPreviousText);
                    int i8 = i5 + i7;
                    String substring = charSequence.toString().substring(i5, i8);
                    int i9 = i5 + i6;
                    String substring2 = this.mPreviousText.substring(i5, i9);
                    if (i7 != i6 || !substring.equals(substring2)) {
                        JavaOnlyMap javaOnlyMap = this.mEditText.mAttributedString;
                        if (javaOnlyMap == null || !javaOnlyMap.hasKey("fragments")) {
                            i4 = i5;
                        } else {
                            String charSequence2 = charSequence.subSequence(i5, i8).toString();
                            String string = javaOnlyMap.getString("string");
                            StringBuilder sb = new StringBuilder();
                            sb.append(string.substring(0, i5));
                            sb.append(charSequence2);
                            sb.append(string.length() > i9 ? string.substring(i9) : "");
                            javaOnlyMap.putString("string", sb.toString());
                            JavaOnlyArray javaOnlyArray2 = (JavaOnlyArray) javaOnlyMap.getArray("fragments");
                            int i10 = i6;
                            String str = charSequence2;
                            boolean z = false;
                            int i11 = 0;
                            int i12 = i5;
                            int i13 = 0;
                            while (i13 < javaOnlyArray2.size() && !z) {
                                JavaOnlyMap javaOnlyMap2 = (JavaOnlyMap) javaOnlyArray2.getMap(i13);
                                String string2 = javaOnlyMap2.getString("string");
                                int length = string2.length() + i11;
                                if (length < i12) {
                                    javaOnlyArray = javaOnlyArray2;
                                } else {
                                    int i14 = i12 - i11;
                                    int length2 = string2.length() - i14;
                                    javaOnlyArray = javaOnlyArray2;
                                    javaOnlyMap2.putString("string", string2.substring(0, i14) + str + string2.substring(i14 + Math.min(i10, length2)));
                                    if (length2 < i10) {
                                        i12 += length2;
                                        i10 -= length2;
                                        str = "";
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                }
                                i13++;
                                i11 = length;
                                javaOnlyArray2 = javaOnlyArray;
                                CharSequence charSequence3 = charSequence;
                            }
                            i6 = i10;
                            i4 = i12;
                        }
                        if (!(this.mEditText.mStateWrapper == null || javaOnlyMap == null)) {
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                            WritableNativeArray writableNativeArray = new WritableNativeArray();
                            for (int i15 = 0; i15 < javaOnlyMap.getArray("fragments").size(); i15++) {
                                ReadableMap map = javaOnlyMap.getArray("fragments").getMap(i15);
                                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                                writableNativeMap3.putDouble("reactTag", (double) map.getInt("reactTag"));
                                writableNativeMap3.putString("string", map.getString("string"));
                                writableNativeArray.pushMap(writableNativeMap3);
                            }
                            writableNativeMap2.putString("string", javaOnlyMap.getString("string"));
                            writableNativeMap2.putArray("fragments", writableNativeArray);
                            writableNativeMap.putInt("mostRecentEventCount", this.mEditText.incrementAndGetEventCounter());
                            writableNativeMap.putMap("textChanged", writableNativeMap2);
                            this.mEditText.mStateWrapper.updateState(writableNativeMap);
                        }
                        this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mEditText.getId(), charSequence.toString(), this.mEditText.incrementAndGetEventCounter()));
                        this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mEditText.getId(), substring, substring2, i4, i4 + i6));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
                if (z) {
                    eventDispatcher.dispatchEvent(new ReactTextInputFocusEvent(reactEditText.getId()));
                    return;
                }
                eventDispatcher.dispatchEvent(new ReactTextInputBlurEvent(reactEditText.getId()));
                eventDispatcher.dispatchEvent(new ReactTextInputEndEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) == 0 && i != 0) {
                    return true;
                }
                boolean blurOnSubmit = reactEditText.getBlurOnSubmit();
                boolean isMultiline = reactEditText.isMultiline();
                ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactTextInputSubmitEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
                if (blurOnSubmit) {
                    reactEditText.clearFocus();
                }
                if (blurOnSubmit || !isMultiline || i == 5 || i == 7) {
                    return true;
                }
                return false;
            }
        });
    }

    private class ReactContentSizeWatcher implements ContentSizeWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private int mPreviousContentHeight = 0;
        private int mPreviousContentWidth = 0;

        public ReactContentSizeWatcher(ReactEditText reactEditText) {
            this.mEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onLayout() {
            int width = this.mEditText.getWidth();
            int height = this.mEditText.getHeight();
            if (this.mEditText.getLayout() != null) {
                width = this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
                height = this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
            }
            if (width != this.mPreviousContentWidth || height != this.mPreviousContentHeight) {
                this.mPreviousContentHeight = height;
                this.mPreviousContentWidth = width;
                this.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.mEditText.getId(), PixelUtil.toDIPFromPixel((float) width), PixelUtil.toDIPFromPixel((float) height)));
            }
        }
    }

    private class ReactSelectionWatcher implements SelectionWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousSelectionEnd;
        private int mPreviousSelectionStart;
        private ReactEditText mReactEditText;

        public ReactSelectionWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onSelectionChanged(int i, int i2) {
            int min = Math.min(i, i2);
            int max = Math.max(i, i2);
            if (this.mPreviousSelectionStart != min || this.mPreviousSelectionEnd != max) {
                this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), min, max));
                this.mPreviousSelectionStart = min;
                this.mPreviousSelectionEnd = max;
            }
        }
    }

    private class ReactScrollWatcher implements ScrollWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousHoriz;
        private int mPreviousVert;
        private ReactEditText mReactEditText;

        public ReactScrollWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            if (this.mPreviousHoriz != i || this.mPreviousVert != i2) {
                this.mEventDispatcher.dispatchEvent(ScrollEvent.obtain(this.mReactEditText.getId(), ScrollEventType.SCROLL, i, i2, 0.0f, 0.0f, 0, 0, this.mReactEditText.getWidth(), this.mReactEditText.getHeight()));
                this.mPreviousHoriz = i;
                this.mPreviousVert = i2;
            }
        }
    }

    @Nullable
    public Map getExportedViewConstants() {
        return MapBuilder.m138of("AutoCapitalizationType", MapBuilder.m141of(ViewProps.NONE, 0, "characters", 4096, "words", 8192, "sentences", 16384));
    }

    public void setPadding(ReactEditText reactEditText, int i, int i2, int i3, int i4) {
        reactEditText.setPadding(i, i2, i3, i4);
    }

    private int getTextBreakStrategy(@Nullable String str) {
        if (str != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1924829944) {
                if (hashCode == -902286926 && str.equals(FtsOptions.TOKENIZER_SIMPLE)) {
                    c = 0;
                }
            } else if (str.equals("balanced")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    return 0;
                case 1:
                    return 2;
            }
        }
        return 1;
    }

    public Object updateState(ReactEditText reactEditText, ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        ReadableNativeMap state = stateWrapper.getState();
        ReadableNativeMap map = state.getMap("attributedString");
        ReadableNativeMap map2 = state.getMap("paragraphAttributes");
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(reactEditText.getContext(), map);
        TextAttributeProps textAttributeProps = new TextAttributeProps(reactStylesDiffMap);
        int textBreakStrategy = getTextBreakStrategy(map2.getString(ViewProps.TEXT_BREAK_STRATEGY));
        reactEditText.mStateWrapper = stateWrapper;
        return ReactTextUpdate.buildReactTextUpdateFromState(orCreateSpannableForText, state.getInt("mostRecentEventCount"), false, textAttributeProps.getTextAlign(), textBreakStrategy, 0, map);
    }
}
