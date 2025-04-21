package com.example.hw6.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CarDealerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ColorScheme(
            primary = PrimaryColor,
            onPrimary = Color.White,
            primaryContainer = PrimaryContainerColor,  // Добавляем цвет для контейнера
            onPrimaryContainer = OnPrimaryContainerColor,  // Добавляем цвет для текста на контейнере
            inversePrimary = InversePrimaryColor,  // Цвет для инверсного primary
            secondary = SecondaryColor,
            onSecondary = Color.Black,
            secondaryContainer = SecondaryContainerColor,  // Добавляем цвет для контейнера secondary
            onSecondaryContainer = OnSecondaryContainerColor,  // Добавляем цвет для текста на контейнере secondary
            tertiary = TertiaryColor,  // Добавляем третичный цвет (можно оставить по умолчанию)
            onTertiary = Color.White,  // Цвет для текста на tertiary
            tertiaryContainer = TertiaryContainerColor,  // Контейнер для tertiary
            onTertiaryContainer = OnTertiaryContainerColor,  // Цвет для текста на контейнере tertiary
            background = BackgroundColor,
            onBackground = Color.Black,
            surface = SurfaceColor,
            onSurface = OnSurfaceColor,
            surfaceVariant = SurfaceVariantColor,  // Цвет для варианта поверхности
            onSurfaceVariant = OnSurfaceVariantColor,  // Цвет для текста на варианте поверхности
            surfaceTint = SurfaceTintColor,  // Тонировка для поверхности
            inverseSurface = InverseSurfaceColor,  // Инверсный цвет для поверхности
            inverseOnSurface = InverseOnSurfaceColor,  // Инверсный цвет для текста на поверхности
            error = ErrorColor,  // Цвет для ошибки
            onError = Color.White,  // Цвет для текста на ошибке
            errorContainer = ErrorContainerColor,  // Контейнер ошибки
            onErrorContainer = OnErrorContainerColor,  // Цвет для текста на контейнере ошибки
            outline = OutlineColor,  // Цвет для обводки
            outlineVariant = OutlineVariantColor,  // Цвет для варианта обводки
            scrim = ScrimColor  // Цвет для затемнения (scrim)
        ),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
