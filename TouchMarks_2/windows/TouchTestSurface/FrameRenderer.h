#pragma once

#include "Direct3DBase.h"

ref class FrameRenderer sealed : public Direct3DBase
{
public:
	FrameRenderer();

	// Direct3DBase methods.
	virtual void CreateDeviceResources() override;
	virtual void CreateWindowSizeDependentResources() override;
	virtual void Render() override;
	
	void swapBackgroundColor();

private:
	float* m_backgroundColor;
};
