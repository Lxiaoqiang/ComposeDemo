package com.example.demo.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.demo.ui.theme.AppColorsProvider


@Composable
fun CommonEditText(
    modifier: Modifier = Modifier,
    hint: String? = null,
    onTextChange: String.() -> Unit = {},
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: String.() -> Unit = {},
    textFieldStyle: TextStyle = LocalTextStyle.current,
    hintTextStyle: TextStyle = LocalTextStyle.current,

    ) {
    var text by remember { mutableStateOf("") }
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leadingIcon?.invoke()
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onTextChange.invoke(it)
            },
            cursorBrush = SolidColor(AppColorsProvider.current.pure),
            singleLine = true,
            modifier = Modifier
                .weight(1f),
            textStyle = textFieldStyle,
            decorationBox = { innerTextField ->
                if (text.isBlank() && !hint.isNullOrBlank())
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        innerTextField()
                        Text(
                            hint,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = hintTextStyle,
                        )
                    } else innerTextField()

            },
            keyboardActions = KeyboardActions {
                keyboardActions(text)
            },
            keyboardOptions = keyboardOptions
        )
        if (text.isNotEmpty()) {
            trailingIcon?.invoke()
        }
    }
}

data class BottomLine(val isShow: Boolean, val color: Color, val lineSize: Dp = 1.dp)