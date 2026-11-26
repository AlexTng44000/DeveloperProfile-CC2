
package com.example.developerprofile.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF335C91),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD9E6FB),
    onPrimaryContainer = Color(0xFF152A44),

    background = Color(0xFFF6F8FD),
    onBackground = Color(0xFF1C2638),

    surface = Color.White,
    onSurface = Color(0xFF1C2638),
    surfaceVariant = Color(0xFFE9EDF5),
    onSurfaceVariant = Color(0xFF465167)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFA6C8FF),
    onPrimary = Color(0xFF08305B),
    primaryContainer = Color(0xFF294B74),
    onPrimaryContainer = Color(0xFFD8E8FF),

    background = Color(0xFF111827),
    onBackground = Color(0xFFE7EDF8),

    surface = Color(0xFF1B2533),
    onSurface = Color(0xFFE7EDF8),
    surfaceVariant = Color(0xFF344154),
    onSurfaceVariant = Color(0xFFD4DBE9)
)

private val ProfileShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(20.dp)
)

@Composable
fun DeveloperProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        },
        typography = Typography,
        shapes = ProfileShapes,
        content = content
    )
}
