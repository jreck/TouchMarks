#include "pch.h"
#include "FrameRenderer.h"

using namespace DirectX;
using namespace Microsoft::WRL;
using namespace Windows::Foundation;
using namespace Windows::UI::Core;

static float blackColor[] = { 0.0f, 0.0f, 0.0f, 1.000f };
static float whiteColor[] = { 1.0f, 1.0f, 1.0f, 1.000f };

FrameRenderer::FrameRenderer() :
	m_backgroundColor(blackColor)
{
}

void FrameRenderer::CreateDeviceResources()
{
	Direct3DBase::CreateDeviceResources();
}

void FrameRenderer::CreateWindowSizeDependentResources()
{
	Direct3DBase::CreateWindowSizeDependentResources();
	// Set the viewport
	D3D11_VIEWPORT viewPort;
	viewPort.Width = m_renderTargetSize.Width;
	viewPort.Height = m_renderTargetSize.Height;
	viewPort.MinDepth = 0.0f;
	viewPort.MaxDepth = 1.0f;
	viewPort.TopLeftX = 0;
	viewPort.TopLeftY = 0;
	m_d3dContext->RSSetViewports(1, &viewPort);
}

void FrameRenderer::swapBackgroundColor()
{
	if (m_backgroundColor == blackColor)
		m_backgroundColor = whiteColor;
	else
		m_backgroundColor = blackColor;
}

void FrameRenderer::Render()
{
	m_d3dContext->ClearRenderTargetView(
		m_renderTargetView.Get(),
		m_backgroundColor
		);
}