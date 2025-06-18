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

object BottomSheetManager {
    private var _isVisible = mutableStateOf(false)
    private var _content: @Composable (() -> Unit)? by mutableStateOf(null)
    
    fun show(content: @Composable () -> Unit = { DefaultContent() }) {
        _content = content
        _isVisible.value = true
    }
    
    fun hide() {
        _isVisible.value = false
        _content = null
    }
    
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Container(mainContent: @Composable BoxScope.() -> Unit) {
        val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
        
        val scale by animateFloatAsState(
            targetValue = if (_isVisible.value) 0.9f else 1f,
            animationSpec = tween(400), label = "scale"
        )
        
        val cornerRadius by animateFloatAsState(
            targetValue = if (_isVisible.value) 12f else 0f,
            animationSpec = tween(400), label = "corner"
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize().background(Color.Black))
            
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

            if (_isVisible.value) {
                ModalBottomSheet(
                    onDismissRequest = { hide() },
                    sheetState = bottomSheetState,
                    windowInsets = WindowInsets(0),
                    modifier = Modifier.fillMaxHeight(0.75f)
                ) {
                    _content?.invoke()
                }
            }
        }
    }
    
    @Composable
    private fun DefaultContent() {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(4.dp)
                    .background(Color.Gray.copy(0.3f), RoundedCornerShape(2.dp))
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text("底部弹窗", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            repeat(5) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text(
                        "选项 ${index + 1}",
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { hide() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("关闭")
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
} 