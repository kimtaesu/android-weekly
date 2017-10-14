package weekly276.hucet.com.weekly278_check_out_local_storage_and_rxjava_backpressure

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.TextView
import io.reactivex.FlowableSubscriber
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit

/**
 * Created by tyler on 2017. 10. 14..
 */
class MainAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val processor = PublishProcessor.create <Int>()
        val seekBar = findViewById(R.id.seekBar) as SeekBar

        seekBar.setOnSeekBarChangeListener(object : SeekBar . OnSeekBarChangeListener {
            override fun onProgressChanged(bar: SeekBar?, progress: Int, fromUser: Boolean) {
                // 검색 막대의 값이 바뀌었을 때 processor에 onNext되는
                println("onProgressChanged ${progress}")
                processor.onNext(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        val textView = findViewById(R.id.text) as TextView

        processor
                .onBackpressureLatest()   // 현재 값을받을
                .subscribe(object : Subscriber <Int> {
                    private var subscription: Subscription? = null
                    private var count = 0
                    override fun onNext(t: Int?) {
                        // 실행에 1000 밀리 세컨드 필요한 처리를 시작
                        Observable.just(0)
                                .delay(1000, TimeUnit.MILLISECONDS)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe {
                                    textView.text = "${++count}. ${seekBar.progress}\n" + textView.text
                                    subscription?.request(1)  // 처리가 끝나고 나서 다음 값을 하나받을
                                }
                    }

                    override fun onError(t: Throwable?) {
                    }

                    override fun onComplete() {
                    }

                    override fun onSubscribe(s: Subscription?) {
                        this.subscription = s  // subscription을 유지
                        s?.request(1)  // 먼저받을 값은 1 개
                    }
                })

    }
}