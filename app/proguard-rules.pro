# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile

# R8/ProGuard에서 무시할 경고들을 지정
-dontwarn sun.misc.**
-dontwarn javax.annotation.**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# 멀티 모듈 환경에서 R8이 생성된 Dagger/Hilt/Circuit 클래스에
# 중복된 이름을 부여하여 발생하는 충돌을 방지
-keep class *.*_Factory { *; }
-keep class *.*_MembersInjector { *; }
-keep class *.*_Component { *; }

# Kotlin 람다, 익명 클래스 등 컴파일러가 생성하는 내부 클래스의 이름을 보호
-keepnames class **$* { *; }

# Retrofit의 동작에 필요한 Reflection 관련 어노테이션 및 속성을 유지
-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepattributes AnnotationDefault

# Retrofit 인터페이스 및 HTTP 메서드 어노테이션을 사용하는 모든 메서드를 보존
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Suspend 함수(코루틴) 사용 시 필요한 Continuation 클래스를 보호
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# OkHttp에서 발생하는 경고를 무시
-dontwarn okhttp3.internal.platform.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**
