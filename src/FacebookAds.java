package com.ujvervueriuv.gbrvfgurweuvn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesActivities;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.androidmanifest.ActivityElement;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.OnDestroyListener;

@DesignerComponent(category = ComponentCategory.EXTENSION, description = "", iconName = "https://icon-icons.com/downloadimage.php?id=130940&root=2108/PNG/32/&file=facebook_icon_130940.png", nonVisible = true, version = 1)
@UsesLibraries("facebook.jar")
@SimpleObject(external = true)
@UsesActivities(activities = {@ActivityElement(configChanges = "keyboardHidden|orientation|screenSize", hardwareAccelerated = "true", name = "com.facebook.ads.AudienceNetworkActivity"), @ActivityElement(configChanges = "keyboardHidden|orientation", hardwareAccelerated = "true", name = "com.facebook.ads.InterstitialAdActivity")})
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE")

public class FacebookAds extends AndroidViewComponent implements OnDestroyListener {
    public Activity activity;
    private AdView adView;
    private Context context;
    private InterstitialAd interstitialAd;
    private NativeAd nativeAd;
    private NativeAdLayout nativeAdLayout;

    public FacebookAds(ComponentContainer container) {
        super(container);
        activity = container.$context();
        context = container.$context();
        AudienceNetworkAds.initialize(container.$context());
    }

    public View getView() {
        return adView;
    }

    @SimpleFunction(description = "Loads A Banner Ad of Size 320x50")
    public void LoadBannerAd(String placementId, AndroidViewComponent container) {
        adView = new AdView((Context) this.activity, placementId, AdSize.BANNER_HEIGHT_50);
        ViewGroup parent = (ViewGroup) container.getView();
        if (parent != null) {
            parent.removeAllViews();
        }
        parent.addView(this.adView, 0, new ViewGroup.LayoutParams(-1, -2));
        adView.setAdListener(new AdListener() {
            public void onError(Ad ad, AdError adError) {
                BannerAdErrorOccoured(adError.getErrorMessage());
            }

            public void onAdLoaded(Ad ad) {
                BannerAdLoaded();
            }

            public void onAdClicked(Ad ad) {
                BannerAdClicked();
            }

            public void onLoggingImpression(Ad ad) {
                BannerAdImpressionLogged();
            }
        });
        adView.loadAd();
    }

    @SimpleFunction(description = "Loads A Banner Ad of Size 320x90")
    public void LoadLargeBannerAd(String placementId, AndroidViewComponent container) {
        adView = new AdView((Context) this.activity, placementId, AdSize.BANNER_HEIGHT_90);
        ViewGroup parent = (ViewGroup) container.getView();
        if (parent != null) {
            parent.removeAllViews();
        }
        parent.addView(adView, 0, new ViewGroup.LayoutParams(-1, -2));
        adView.setAdListener(new AdListener() {
            public void onError(Ad ad, AdError adError) {
                BannerAdErrorOccoured(adError.getErrorMessage());
            }

            public void onAdLoaded(Ad ad) {
                BannerAdLoaded();
            }

            public void onAdClicked(Ad ad) {
                BannerAdClicked();
            }

            public void onLoggingImpression(Ad ad) {
                BannerAdImpressionLogged();
            }
        });
        adView.loadAd();
    }

    @SimpleFunction(description = "Loads A Banner Ad of Size 320x250")
    public void LoadRectangleBannerAd(String placementId, AndroidViewComponent container) {
        adView = new AdView((Context) activity, placementId, AdSize.RECTANGLE_HEIGHT_250);
        ViewGroup parent = (ViewGroup) container.getView();
        if (parent != null) {
            parent.removeAllViews();
        }
        parent.addView(this.adView, 0, new ViewGroup.LayoutParams(-1, -2));
        adView.setAdListener(new AdListener() {
            public void onError(Ad ad, AdError adError) {
                BannerAdErrorOccoured(adError.getErrorMessage());
            }

            public void onAdLoaded(Ad ad) {
                BannerAdLoaded();
            }

            public void onAdClicked(Ad ad) {
                BannerAdClicked();
            }

            public void onLoggingImpression(Ad ad) {
                BannerAdImpressionLogged();
            }
        });
        adView.loadAd();
    }

    @SimpleFunction
    public void LoadInterstitialAd(String placementId) {
        interstitialAd = new InterstitialAd(this.activity, placementId);
        interstitialAd.setAdListener(new InterstitialAdListener() {
            public void onInterstitialDisplayed(Ad ad) {
                InterstitialAdDisplayed();
            }

            public void onInterstitialDismissed(Ad ad) {
                InterstitialAdDismissed();
            }

            public void onError(Ad ad, AdError adError) {
                InterstitialAdErrorOccoured(adError.getErrorMessage());
            }

            public void onAdLoaded(Ad ad) {
                InterstitialAdLoaded();
            }

            public void onAdClicked(Ad ad) {
                InterstitialAdClicked();
            }

            public void onLoggingImpression(Ad ad) {
                InterstitialAdImpressionLogged();
            }
        });
        interstitialAd.loadAd();
    }

    @SimpleFunction
    public void ShowInterstitialAd() {
        interstitialAd.show();
    }

    @SimpleFunction
    public void LoadNativeAd(final String placementId,final String backgroundColor,final String titleTextColor,final String descriptionTextColor,final String buttonColor,final String buttonTextColor,final AndroidViewComponent nativeAdContainer) {
        nativeAd = new NativeAd((Context) activity, placementId);
        final AndroidViewComponent androidViewComponent = nativeAdContainer;
        nativeAd.setAdListener(new NativeAdListener() {
            public void onMediaDownloaded(Ad ad) {
                NativeAdMediaDownloaded();
            }

            public void onError(Ad ad, AdError adError) {
                NativeAdErrorOccoured(adError.getErrorMessage());
            }

            public void onAdLoaded(Ad ad) {
                View adView = NativeAdView.render((Context) activity, nativeAd, new NativeAdViewAttributes().setBackgroundColor(Color.parseColor(backgroundColor)).setTitleTextColor(Color.parseColor(titleTextColor)).setDescriptionTextColor(Color.parseColor(descriptionTextColor)).setButtonColor(Color.parseColor(buttonColor)).setButtonTextColor(Color.parseColor(buttonTextColor)));
                ViewGroup parent = (ViewGroup) androidViewComponent.getView();
                if (parent != null) {
                    parent.removeAllViews();
                }
                parent.addView(adView, 0, new ViewGroup.LayoutParams(-1, -2));
            }

            public void onAdClicked(Ad ad) {
                NativeAdClicked();
            }

            public void onLoggingImpression(Ad ad) {
                NativeAdImpressionLogged();
            }
        });
        nativeAd.loadAd();
    }

    @SimpleEvent
    public void BannerAdErrorOccoured(String errorMessage) {
        EventDispatcher.dispatchEvent(this, "BannerAdErrorOccoured", errorMessage);
    }

    @SimpleEvent
    public void BannerAdLoaded() {
        EventDispatcher.dispatchEvent(this, "BannerAdLoaded");
    }

    @SimpleEvent
    public void BannerAdClicked() {
        EventDispatcher.dispatchEvent(this, "BannerAdClicked");
    }

    @SimpleEvent
    public void BannerAdImpressionLogged() {
        EventDispatcher.dispatchEvent(this, "BannerAdImpressionLogged");
    }

    @SimpleEvent
    public void InterstitialAdDisplayed() {
        EventDispatcher.dispatchEvent(this, "InterstitialAdDisplayed");
    }

    @SimpleEvent
    public void InterstitialAdDismissed() {
        EventDispatcher.dispatchEvent(this, "InterstitialAdDismissed");
    }

    @SimpleEvent
    public void InterstitialAdErrorOccoured(String errorMessage) {
        EventDispatcher.dispatchEvent(this, "InterstitialAdErrorOccoured", errorMessage);
    }

    @SimpleEvent
    public void InterstitialAdLoaded() {
        EventDispatcher.dispatchEvent(this, "InterstitialAdLoaded");
    }

    @SimpleEvent
    public void InterstitialAdClicked() {
        EventDispatcher.dispatchEvent(this, "InterstitialAdClicked");
    }

    @SimpleEvent
    public void InterstitialAdImpressionLogged() {
        EventDispatcher.dispatchEvent(this, "InterstitialAdImpressionLogged");
    }

    @SimpleEvent
    public void NativeAdMediaDownloaded() {
        EventDispatcher.dispatchEvent(this, "NativeAdMediaDownloaded");
    }

    @SimpleEvent
    public void NativeAdErrorOccoured(String errorMessage) {
        EventDispatcher.dispatchEvent(this, "NativeAdErrorOccoured", errorMessage);
    }

    @SimpleEvent
    public void NativeAdClicked() {
        EventDispatcher.dispatchEvent(this, "NativeAdClicked");
    }

    @SimpleEvent
    public void NativeAdImpressionLogged() {
        EventDispatcher.dispatchEvent(this, "NativeAdImpressionLogged");
    }

    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
    }
}
