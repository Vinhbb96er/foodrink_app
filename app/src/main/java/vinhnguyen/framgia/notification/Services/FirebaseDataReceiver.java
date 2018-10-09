//package vinhnguyen.framgia.notification.Services;
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.support.v4.app.NotificationCompat;
//import android.support.v4.content.WakefulBroadcastReceiver;
//import android.util.Log;
//
//import vinhnguyen.framgia.notification.Controllers.OrderRequestActivity;
//import vinhnguyen.framgia.notification.R;
//
//public class FirebaseDataReceiver extends WakefulBroadcastReceiver {
//
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        Log.d("abc", "abc");
//
//        Intent pintent = new Intent(context, OrderRequestActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle(intent.getExtras().getString("title"))
//                .setContentText(intent.getExtras().getString("message"))
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setPriority(NotificationManager.IMPORTANCE_HIGH)
//                .addAction(new NotificationCompat.Action(
//                        R.mipmap.ic_launcher,
//                        "Reject",
//                        PendingIntent.getActivity(context, 0, pintent, PendingIntent.FLAG_UPDATE_CURRENT)))
//                .addAction(new NotificationCompat.Action(
//                        R.mipmap.ic_launcher,
//                        "Accept",
//                        PendingIntent.getActivity(context, 0, pintent, PendingIntent.FLAG_UPDATE_CURRENT)));
//
//
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(0, builder.build());
//    }
//}