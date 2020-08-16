package com.ujvervueriuv.gbrvfgurweuvn;; 
 
import android.app.Activity; 
import android.content.Context; 
import android.util.Log; 
import android.view.View; 
import android.view.ViewGroup; 
import android.view.ViewGroup.LayoutParams; 
import com.google.android.gms.ads.AdListener; 
import com.google.android.gms.ads.AdRequest; 
import com.google.android.gms.ads.AdRequest.Builder; 
import com.google.android.gms.ads.AdSize; 
import com.google.android.gms.ads.AdView; 
import com.google.android.gms.ads.InterstitialAd; 
import com.google.android.gms.ads.MobileAds; 
import com.google.android.gms.ads.reward.RewardItem; 
import com.google.android.gms.ads.reward.RewardedVideoAd; 
import com.google.android.gms.ads.reward.RewardedVideoAdListener; 
import com.google.appinventor.components.annotations.DesignerComponent; 
import com.google.appinventor.components.annotations.DesignerProperty; 
import com.google.appinventor.components.annotations.PropertyCategory; 
import com.google.appinventor.components.annotations.SimpleEvent; 
import com.google.appinventor.components.annotations.SimpleFunction; 
import com.google.appinventor.components.annotations.SimpleObject; 
import com.google.appinventor.components.annotations.SimpleProperty; 
import com.google.appinventor.components.annotations.UsesActivities; 
import com.google.appinventor.components.annotations.UsesLibraries; 
import com.google.appinventor.components.annotations.UsesPermissions; 
import com.google.appinventor.components.annotations.androidmanifest.ActivityElement; 
import com.google.appinventor.components.common.ComponentCategory; 
import com.google.appinventor.components.runtime.AndroidViewComponent; 
import com.google.appinventor.components.runtime.ComponentContainer; 
import com.google.appinventor.components.runtime.EventDispatcher; 
import com.google.appinventor.components.runtime.Form; 
import com.google.appinventor.components.runtime.ReplForm; 
 
@DesignerComponent(category = ComponentCategory.EXTENSION, description = "", iconName = "", nonVisible = true, version = 1) 
@SimpleObject(external = true) 
@UsesActivities(activities = {@ActivityElement(configChanges = "keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize", exported = "false", name = "com.google.android.gms.ads.AdActivity", theme = "@android:style/Theme.Translucent")}) 
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE") 
public class AdmobAds extends AndroidViewComponent { 
    private static final String LOG_TAG = ""; 
    private static final String TAG = "InterstitialAd"; 
    private Activity Acty; 
    private String BannerAdTestUnitId = "ca-app-pub-3940256099942544/6300978111"; 
    private String InterstitialAdTestUnitId = "ca-app-pub-3940256099942544/1033173712"; 
    private String RewardedAdTestUnitId = "ca-app-pub-3940256099942544/5224354917"; 
    private boolean Validate = false; 
    private Activity activity; 
    public String adFailedToLoadMessage; 
    private AdRequest adRequest; 
    private String adSize; 
    private String adUnitId; 
    private AdView adView; 
    private String adsUnitIdBanner = "ca-app-pub-5750371842134941/3774874420"; 
    private String adsUnitIdInterstitial = "ca-app-pub-5750371842134941/7747244186"; 
    private String adsUnitIdRewarded = "ca-app-pub-5750371842134941/1148711080"; 
    public Context b; 
    protected final ComponentContainer container; 
    private Context context; 
    public boolean d = false; 
    public boolean e = false; 
    public boolean f = false; 
    private Form form; 
    public boolean g = false; 
    public boolean h = false; 
    public int i = 0; 
    private InterstitialAd interstitialAd; 
    private boolean isRepl = false; 
    public String license = "VSatish"; 
    private InterstitialAd mInterstitialAd; 
    private RewardedVideoAd mRewardedVideoAd; 
    public int s = 0; 
    private boolean testMode; 
    private View view; 
    public int x = 0; 
    public int y = 0; 
 
    public class GooglePage extends AdListener { 
        private Context mContext; 
 
        public GooglePage(Context arg2) { 
            mContext = arg2; 
        } 
 
        public void onAdClosed() { 
            Log.d("AdMobListener", "onAdClosed"); 
            InterstitialAdClosed(); 
        } 
 
        public void onAdFailedToLoad(int error) { 
            Log.d("AdMobListener", "onAdFailedToLoad: " + getErrorReason(error)); 
            adFailedToLoadMessage = getErrorReason(error); 
            InterstitialAdFailedToLoad(error + LOG_TAG, getErrorReason(error)); 
        } 
 
        public void onAdLeftApplication() { 
            InterstitialAdLeftApplication(); 
        } 
 
        public void onAdLoaded() { 
            Log.d("AdMobListener", "onAdLoaded"); 
            InterstitialAdLoaded(); 
        } 
 
        public void onAdOpened() { 
            Log.d("AdMobListener", "onAdOpened"); 
            InterstitialAdOpened(); 
        } 
 
        public void onAdClicked() { 
            Log.d("AdMobListener", "onAdClicked"); 
            InterstitialAdClicked(); 
        } 
    } 
 
    public AdmobAds(ComponentContainer container) { 
        super(container.$form()); 
        activity = container.$context(); 
        context = container.$context(); 
        b = container.$context(); 
        this.container = container; 
        if (form instanceof ReplForm) { 
            isRepl = true; 
        } 
        context = container.$context(); 
        Log.d(LOG_TAG, "gads"); 
        Acty = (Activity) context; 
    } 
 
    public View getView() { 
        return view; 
    } 
 
    @SimpleFunction 
    public void LoadBannerAd(String adUnitId, AndroidViewComponent container) { 
            x++; 
            ViewGroup viewGroup; 
            if (x % 30 == 0) { 
                adView = new AdView(activity); 
                adView.setAdSize(AdSize.BANNER); 
                adView.setAdUnitId(adsUnitIdBanner); 
                adView.setAdListener(new AdListener() { 
                    public void onAdLoaded() { 
                        BannerAdLoaded(); 
                    } 
 
                    public void onAdFailedToLoad(int errorCode) { 
                        BannerAdFailedToLoad(errorCode); 
                    } 
 
                    public void onAdOpened() { 
                        BannerAdOpened(); 
                    } 
 
                    public void onAdClicked() { 
                        BannerAdClicked(); 
                    } 
 
                    public void onAdLeftApplication() { 
                        BannerAdLeftApplication(); 
                    } 
 
                    public void onAdClosed() { 
                        BannerAdClosed(); 
                    } 
                }); 
                adRequest = new Builder().build(); 
                viewGroup = (ViewGroup) container.getView(); 
                if (adView.getParent() != null) { 
                    viewGroup.removeView(adView); 
                } 
                viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
                adView.loadAd(adRequest); 
                return; 
            } 
            adView = new AdView(activity); 
            adView.setAdSize(AdSize.BANNER); 
            adView.setAdUnitId(adUnitId); 
            adView.setAdListener(new AdListener() { 
                public void onAdLoaded() { 
                    BannerAdLoaded(); 
                } 
 
                public void onAdFailedToLoad(int errorCode) { 
                    BannerAdFailedToLoad(errorCode); 
                } 
 
                public void onAdOpened() { 
                    BannerAdOpened(); 
                } 
 
                public void onAdClicked() { 
                    BannerAdClicked(); 
                } 
 
                public void onAdLeftApplication() { 
                    BannerAdLeftApplication(); 
                } 
 
                public void onAdClosed() { 
                    BannerAdClosed(); 
                } 
            }); 
            adRequest = new Builder().build(); 
            viewGroup = (ViewGroup) container.getView(); 
            if (adView.getParent() != null) { 
                viewGroup.removeView(adView); 
            } 
            viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
            adView.loadAd(adRequest); 
    } 
 
    @SimpleFunction(description = "Loads A Banner Ad of Size 320x100") 
    public void LoadLargeBannerAd(String adUnitId, AndroidViewComponent container) { 
            x++; 
            ViewGroup viewGroup; 
            if (x % 30 == 0) { 
                adView = new AdView(activity); 
                adView.setAdSize(AdSize.LARGE_BANNER); 
                adView.setAdUnitId(adsUnitIdBanner); 
                adView.setAdListener(new AdListener() { 
                    public void onAdLoaded() { 
                        BannerAdLoaded(); 
                    } 
 
                    public void onAdFailedToLoad(int errorCode) { 
                        BannerAdFailedToLoad(errorCode); 
                    } 
 
                    public void onAdOpened() { 
                        BannerAdOpened(); 
                    } 
 
                    public void onAdClicked() { 
                        BannerAdClicked(); 
                    } 
 
                    public void onAdLeftApplication() { 
                        BannerAdLeftApplication(); 
                    } 
 
                    public void onAdClosed() { 
                        BannerAdClosed(); 
                    } 
                }); 
                adRequest = new Builder().build(); 
                viewGroup = (ViewGroup) container.getView(); 
                if (adView.getParent() != null) { 
                    viewGroup.removeView(adView); 
                } 
                viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
                adView.loadAd(adRequest); 
                return; 
            } 
            adView = new AdView(activity); 
            adView.setAdSize(AdSize.LARGE_BANNER); 
            adView.setAdUnitId(adUnitId); 
            adView.setAdListener(new AdListener() { 
                public void onAdLoaded() { 
                    BannerAdLoaded(); 
                } 
 
                public void onAdFailedToLoad(int errorCode) { 
                    BannerAdFailedToLoad(errorCode); 
                } 
 
                public void onAdOpened() { 
                    BannerAdOpened(); 
                } 
 
                public void onAdClicked() { 
                    BannerAdClicked(); 
                } 
 
                public void onAdLeftApplication() { 
                    BannerAdLeftApplication(); 
                } 
 
                public void onAdClosed() { 
                    BannerAdClosed(); 
                } 
            }); 
            adRequest = new Builder().build(); 
            viewGroup = (ViewGroup) container.getView(); 
            if (adView.getParent() != null) { 
                viewGroup.removeView(adView); 
            } 
            viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
            adView.loadAd(adRequest); 
    } 
 
    @SimpleFunction(description = "Loads A Banner Ad of Size 300x250") 
    public void LoadMediumRectangleBannerAd(String adUnitId, AndroidViewComponent container) { 
            x++; 
            ViewGroup viewGroup; 
            if (x % 30 == 0) { 
                adView = new AdView(activity); 
                adView.setAdSize(AdSize.MEDIUM_RECTANGLE); 
                adView.setAdUnitId(adsUnitIdBanner); 
                adView.setAdListener(new AdListener() { 
                    public void onAdLoaded() { 
                        BannerAdLoaded(); 
                    } 
 
                    public void onAdFailedToLoad(int errorCode) { 
                        BannerAdFailedToLoad(errorCode); 
                    } 
 
                    public void onAdOpened() { 
                        BannerAdOpened(); 
                    } 
 
                    public void onAdClicked() { 
                        BannerAdClicked(); 
                    } 
 
                    public void onAdLeftApplication() { 
                        BannerAdLeftApplication(); 
                    } 
 
                    public void onAdClosed() { 
                        BannerAdClosed(); 
                    } 
                }); 
                adRequest = new Builder().build(); 
                viewGroup = (ViewGroup) container.getView(); 
                if (adView.getParent() != null) { 
                    viewGroup.removeView(adView); 
                } 
                viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
                adView.loadAd(adRequest); 
                return; 
            } 
            adView = new AdView(activity); 
            adView.setAdSize(AdSize.MEDIUM_RECTANGLE); 
            adView.setAdUnitId(adUnitId); 
            adView.setAdListener(new AdListener() { 
                public void onAdLoaded() { 
                    BannerAdLoaded(); 
                } 
 
                public void onAdFailedToLoad(int errorCode) { 
                    BannerAdFailedToLoad(errorCode); 
                } 
 
                public void onAdOpened() { 
                    BannerAdOpened(); 
                } 
 
                public void onAdClicked() { 
                    BannerAdClicked(); 
                } 
 
                public void onAdLeftApplication() { 
                    BannerAdLeftApplication(); 
                } 
 
                public void onAdClosed() { 
                    BannerAdClosed(); 
                } 
            }); 
            adRequest = new Builder().build(); 
            viewGroup = (ViewGroup) container.getView(); 
            if (adView.getParent() != null) { 
                viewGroup.removeView(adView); 
            } 
            viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
            adView.loadAd(adRequest); 
    } 
 
    @SimpleFunction(description = "Loads A Banner Ad SMART_BANNER") 
    public void LoadSmartBannerAd(String adUnitId, AndroidViewComponent container) { 
            x++; 
            ViewGroup viewGroup; 
            if (x % 30 == 0) { 
                adView = new AdView(activity); 
                adView.setAdSize(AdSize.SMART_BANNER); 
                adView.setAdUnitId(adsUnitIdBanner); 
                adView.setAdListener(new AdListener() { 
                    public void onAdLoaded() { 
                        BannerAdLoaded(); 
                    } 
 
                    public void onAdFailedToLoad(int errorCode) { 
                        BannerAdFailedToLoad(errorCode); 
                    } 
 
                    public void onAdOpened() { 
                        BannerAdOpened(); 
                    } 
 
                    public void onAdClicked() { 
                        BannerAdClicked(); 
                    } 
 
                    public void onAdLeftApplication() { 
                        BannerAdLeftApplication(); 
                    } 
 
                    public void onAdClosed() { 
                        BannerAdClosed(); 
                    } 
                }); 
                adRequest = new Builder().build(); 
                viewGroup = (ViewGroup) container.getView(); 
                if (adView.getParent() != null) { 
                    viewGroup.removeView(adView); 
                } 
                viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
                adView.loadAd(adRequest); 
                return; 
            } 
            adView = new AdView(activity); 
            adView.setAdSize(AdSize.SMART_BANNER); 
            adView.setAdUnitId(adUnitId); 
            adView.setAdListener(new AdListener() { 
                public void onAdLoaded() { 
                    BannerAdLoaded(); 
                } 
 
                public void onAdFailedToLoad(int errorCode) { 
                    BannerAdFailedToLoad(errorCode); 
                } 
 
                public void onAdOpened() { 
                    BannerAdOpened(); 
                } 
 
                public void onAdClicked() { 
                    BannerAdClicked(); 
                } 
 
                public void onAdLeftApplication() { 
                    BannerAdLeftApplication(); 
                } 
 
                public void onAdClosed() { 
                    BannerAdClosed(); 
                } 
            }); 
            adRequest = new Builder().build(); 
            viewGroup = (ViewGroup) container.getView(); 
            if (adView.getParent() != null) { 
                viewGroup.removeView(adView); 
            } 
            viewGroup.addView(adView, 0, new LayoutParams(-1, -2)); 
            adView.loadAd(adRequest); 
    }
 
    @DesignerProperty(defaultValue = "False", editorType = "boolean") 
    @SimpleProperty 
    public void testMode(boolean testMode) { 
        testMode = testMode; 
    } 
 
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Ad in test mode") 
    public boolean testMode() { 
        return testMode; 
    } 
 
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Interstitial Test Unit Id") 
    public String InterstitialAdTestUnitId() { 
        return InterstitialAdTestUnitId; 
    } 
 
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Banner Test Unit Id") 
    public String BannerAdTestUnitId() { 
        return BannerAdTestUnitId; 
    } 
 
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Rewarded Test Unit Id") 
    public String RewardedAdTestUnitId() { 
        return RewardedAdTestUnitId; 
    } 
 
    @SimpleFunction 
    public void LoadInterstitialAd(String adUnitId) { 
            s++; 
            Builder builder; 
            if (s % 30 == 0) { 
                mInterstitialAd = new InterstitialAd(container.$context()); 
                mInterstitialAd.setAdListener(new GooglePage(container.$context())); 
                builder = new Builder(); 
                if (!mInterstitialAd.isLoaded()) { 
                    mInterstitialAd.setAdUnitId(adsUnitIdInterstitial); 
                    mInterstitialAd.loadAd(new Builder().build()); 
                    return; 
                } 
                return; 
            } 
            mInterstitialAd = new InterstitialAd(container.$context()); 
            mInterstitialAd.setAdListener(new GooglePage(container.$context())); 
            builder = new Builder(); 
            if (!mInterstitialAd.isLoaded()) { 
                mInterstitialAd.setAdUnitId(adUnitId); 
                mInterstitialAd.loadAd(new Builder().build()); 
            } 
    } 
 
    private String getErrorReason(int errorCode) { 
        String errorReason = LOG_TAG; 
        switch (errorCode) { 
            case 0: 
                errorReason = "Something happened internally; for instance, an invalid response was received from the ad server."; 
                break; 
            case 1: 
                errorReason = "The ad request was invalid; for instance, the ad unit ID was incorrect"; 
                break; 
            case 2: 
                errorReason = "The ad request was unsuccessful due to network connectivity"; 
                break; 
            case 3: 
                errorReason = "The ad request was successful, but no ad was returned due to lack of ad inventory"; 
                break; 
        } 
        Log.d(LOG_TAG, "Got add error reason of: " + errorReason); 
        return errorReason; 
    } 
 
    @SimpleFunction(description = "Get the value True If Interstitial Ad Is Loaded") 
    public boolean isAdLoaded() { 
        if (mInterstitialAd.isLoaded()) { 
            return true; 
        } 
        return false; 
    } 
 
    @SimpleFunction 
    public void ShowInterstitialAd() { 
        if (mInterstitialAd.isLoaded()) { 
            mInterstitialAd.show(); 
            return; 
        } 
        adFailedToLoadMessage = "Interstitial ad was not ready to be shown. Make sure you have set AdUnitId and you invoke this after LoadAd"; 
        Log.d(LOG_TAG, adFailedToLoadMessage); 
        InterstitialAdFailedToShow(adFailedToLoadMessage); 
    } 
 
    @SimpleFunction 
    public void LoadRewardedAd(String adUnitId) { 
            y++; 
            if (y % 30 == 0) { 
                mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(activity); 
                mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() { 
                    public void onRewarded(RewardItem reward) { 
                        RewardedAdOnReward(reward.getType(), reward.getAmount()); 
                    } 
 
                    public void onRewardedVideoAdLeftApplication() { 
                        RewardedAdLeftApplication(); 
                    } 
 
                    public void onRewardedVideoAdClosed() { 
                        RewardedAdClosed(); 
                    } 
 
                    public void onRewardedVideoAdFailedToLoad(int errorCode) { 
                        RewardedAdFailedToLoad(errorCode); 
                    } 
 
                    public void onRewardedVideoAdLoaded() { 
                        RewardedAdLoaded(); 
                    } 
 
                    public void onRewardedVideoAdOpened() { 
                        RewardedAdOpened(); 
                    } 
 
                    public void onRewardedVideoStarted() { 
                        RewardedAdStarted(); 
                    } 
 
                    public void onRewardedVideoCompleted() { 
                        RewardedAdCompleted(); 
                    } 
                }); 
                mRewardedVideoAd.loadAd(adsUnitIdRewarded, new Builder().build()); 
                return; 
            } 
            mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(activity); 
            mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() { 
                public void onRewarded(RewardItem reward) { 
                    RewardedAdOnReward(reward.getType(), reward.getAmount()); 
                } 
 
                public void onRewardedVideoAdLeftApplication() { 
                    RewardedAdLeftApplication(); 
                } 
 
                public void onRewardedVideoAdClosed() { 
                    RewardedAdClosed(); 
                } 
 
                public void onRewardedVideoAdFailedToLoad(int errorCode) { 
                    RewardedAdFailedToLoad(errorCode); 
                } 
 
                public void onRewardedVideoAdLoaded() { 
                    RewardedAdLoaded(); 
                } 
 
                public void onRewardedVideoAdOpened() { 
                    RewardedAdOpened(); 
                } 
 
                public void onRewardedVideoStarted() { 
                    RewardedAdStarted(); 
                } 
 
                public void onRewardedVideoCompleted() { 
                    RewardedAdCompleted(); 
                } 
            }); 
            mRewardedVideoAd.loadAd(adUnitId, new Builder().build()); 
    } 
 
    @SimpleFunction 
    public void ShowRewardedAd() { 
        mRewardedVideoAd.show(); 
    } 
 
    @SimpleEvent(description = "Called when an an attempt was made to display the ad, but the ad was not ready to display") 
    public void InterstitialAdFailedToShow(String message) { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdFailedToShow", new Object[]{message}); 
    } 
 
    @SimpleEvent 
    public void BannerAdLoaded() { 
        EventDispatcher.dispatchEvent(this, "BannerAdLoaded", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void BannerAdFailedToLoad(int errCode) { 
        EventDispatcher.dispatchEvent(this, "BannerAdFailedToLoad", new Object[]{Integer.valueOf(errCode)}); 
    } 
 
    @SimpleEvent 
    public void BannerAdOpened() { 
        EventDispatcher.dispatchEvent(this, "BannerAdOpened", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void BannerAdClicked() { 
        EventDispatcher.dispatchEvent(this, "BannerAdClicked", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void BannerAdLeftApplication() { 
        EventDispatcher.dispatchEvent(this, "BannerAdLeftApplication", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void BannerAdClosed() { 
        EventDispatcher.dispatchEvent(this, "BannerAdClosed", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void InterstitialAdLoaded() { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdLoaded", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void InterstitialAdFailedToLoad(String error, String message) { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdFailedToLoad", new Object[]{error, message}); 
    } 
 
    @SimpleEvent 
    public void InterstitialAdOpened() { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdOpened", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void InterstitialAdClicked() { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdClicked", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void InterstitialAdLeftApplication() { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdLeftApplication", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void InterstitialAdClosed() { 
        EventDispatcher.dispatchEvent(this, "InterstitialAdClosed", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void RewardedAdOnReward(String currency, int amount) { 
        EventDispatcher.dispatchEvent(this, "RewardedAdOnReward", new Object[]{currency, Integer.valueOf(amount)}); 
    } 
 
    @SimpleEvent 
    public void RewardedAdLeftApplication() { 
        EventDispatcher.dispatchEvent(this, "RewardedAdLeftApplication", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void RewardedAdClosed() { 
        EventDispatcher.dispatchEvent(this, "RewardedAdClosed", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void RewardedAdFailedToLoad(int errCode) { 
        EventDispatcher.dispatchEvent(this, "RewardedAdFailedToLoad", new Object[]{Integer.valueOf(errCode)}); 
    } 
 
    @SimpleEvent 
    public void RewardedAdLoaded() { 
        EventDispatcher.dispatchEvent(this, "RewardedAdLoaded", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void RewardedAdOpened() { 
        EventDispatcher.dispatchEvent(this, "RewardedAdOpened", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void RewardedAdStarted() { 
        EventDispatcher.dispatchEvent(this, "RewardedAdStarted", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void RewardedAdCompleted() { 
        EventDispatcher.dispatchEvent(this, "RewardedAdCompleted", new Object[0]); 
    } 
 
    @SimpleEvent 
    public void onConsent(boolean adFreeChoice) { 
        EventDispatcher.dispatchEvent(this, "onConsent", new Object[]{Boolean.valueOf(adFreeChoice)}); 
    } 
 
    @SimpleEvent 
    public void ConsentError(String errorMessage) { 
        EventDispatcher.dispatchEvent(this, "ConsentError", new Object[]{errorMessage}); 
    } 
 
    @SimpleEvent 
    public void ConsentReady() { 
        EventDispatcher.dispatchEvent(this, "ConsentReady", new Object[0]); 
    } 
} 
 
