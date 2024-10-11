package com.utfpr.pos.appcontatos2.ui.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utfpr.pos.appcontatos2.R
import com.utfpr.pos.appcontatos2.ui.theme.AppContatos2Theme

@Composable
fun ContactsListScreen (modifier: Modifier = Modifier) {
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar (modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = { Text(stringResource(R.string.contatos))}
    )
}
@Preview(showBackground = true)
@Composable
private fun AppBarPreview() {
   AppContatos2Theme {
       AppBar()
   }
}

@Composable
private fun LoadingContent(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.size(48.dp)
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.carregando_seus_contatos),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadingContentPreview(modifier: Modifier = Modifier) {
    AppContatos2Theme {
        LoadingContent()
    }
}

@Composable
private fun ErrorContent(
    modifier: Modifier = Modifier,
    onTryAgainPressed: () -> Unit //callback
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        val defaultColor = MaterialTheme.colorScheme.primary

        Icon(
            imageVector = Icons.Filled.CloudOff,
            contentDescription = stringResource(R.string.loading_error),
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(80.dp)
        )
        val textPadding = PaddingValues(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp
        )
        Text(
            modifier = Modifier.padding(textPadding),
            text = stringResource(R.string.loading_error),
            style = MaterialTheme.typography.titleLarge,
            color = defaultColor
        )
        Text(
            modifier = Modifier.padding(textPadding),
            text = stringResource(R.string.wait_and_try_again),
            style = MaterialTheme.typography.titleSmall,
            color = defaultColor
        )
        ElevatedButton(
            onClick = onTryAgainPressed,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(stringResource(R.string.try_again))
        }
    }
}

@Preview(showBackground = true, heightDp = 400)
@Composable
private fun ErrorContentPreview(modifier: Modifier = Modifier) {
    AppContatos2Theme {
        ErrorContent(
            onTryAgainPressed = {}
        )
    }
}


@Composable
private fun EmptyList(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.no_data),
            contentDescription = stringResource(R.string.no_data)
        )
        Text(
            text = stringResource(R.string.no_data),
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.no_data_hint),
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center

        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyListPreview(modifier: Modifier = Modifier) {
    AppContatos2Theme {
        EmptyList()
    }
}

