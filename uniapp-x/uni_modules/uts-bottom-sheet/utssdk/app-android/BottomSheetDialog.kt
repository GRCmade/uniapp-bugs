package com.yuhe.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaledBottomSheetDialog(
    showBottomSheet: Boolean,
    onDismiss: () -> Unit,
    content: @Composable (BoxScope.() -> Unit)
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    
    // 缩放动画
    val scale by animateFloatAsState(
        targetValue = if (showBottomSheet) 0.9f else 1f,
        animationSpec = tween(durationMillis = 400),
        label = "scale_animation"
    )
    
    // 圆角动画
    val cornerRadius by animateFloatAsState(
        targetValue = if (showBottomSheet) 12f else 0f,
        animationSpec = tween(durationMillis = 400),
        label = "corner_animation"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // 外层黑色背景容器
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )
        
        // 主内容区域，应用缩放和圆角
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale)
                .clip(RoundedCornerShape(cornerRadius.dp))
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                content = content
            )
        }

        // 底部弹窗 - 独立于主内容区域
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = bottomSheetState,
                windowInsets = WindowInsets(0),
                modifier = Modifier.fillMaxHeight(0.75f)
            ) {
                DefaultBottomSheetContent(
                    onDismiss = onDismiss
                )
            }
        }
    }
}

@Composable
fun DefaultBottomSheetContent(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 顶部拖拽指示器
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(4.dp)
                .background(
                    color = Color.Gray.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(2.dp)
                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "底部弹窗",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 示例内容
        repeat(10) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Text(
                    text = "列表项目 ${index + 1}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Start
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onDismiss,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("关闭")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetDialog(
    showBottomSheet: Boolean,
    onDismiss: () -> Unit,
    mainContent: @Composable (BoxScope.() -> Unit),
    bottomSheetContent: @Composable () -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    
    // 缩放动画
    val scale by animateFloatAsState(
        targetValue = if (showBottomSheet) 0.9f else 1f,
        animationSpec = tween(durationMillis = 400),
        label = "scale_animation"
    )
    
    // 圆角动画
    val cornerRadius by animateFloatAsState(
        targetValue = if (showBottomSheet) 12f else 0f,
        animationSpec = tween(durationMillis = 400),
        label = "corner_animation"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // 外层黑色背景容器
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )
        
        // 主内容区域，应用缩放和圆角
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale)
                .clip(RoundedCornerShape(cornerRadius.dp))
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                content = mainContent
            )
        }

        // 底部弹窗 - 独立于主内容区域
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = bottomSheetState,
                windowInsets = WindowInsets(0),
                modifier = Modifier.fillMaxHeight(0.75f)
            ) {
                bottomSheetContent()
            }
        }
    }
} 