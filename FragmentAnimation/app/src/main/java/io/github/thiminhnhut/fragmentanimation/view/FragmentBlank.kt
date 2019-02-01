package io.github.thiminhnhut.fragmentanimation.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import io.github.thiminhnhut.fragmentanimation.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mText: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    private var editTextFragment: EditText? = null
    private var buttonFragment: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mText = arguments!!.getString(TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        buttonFragment = view.findViewById(R.id.button_fragment)
        editTextFragment = view.findViewById(R.id.edittext_fragment)
        editTextFragment!!.setText(mText)
        editTextFragment!!.requestFocus()

        buttonFragment!!.setOnClickListener {
            val sendBackText = editTextFragment!!.text.toString()
            sendBack(sendBackText)
        }

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun sendBack(sendBackText: String) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(sendBackText)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(sendBackText: String)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val TEXT = "text"

        // TODO: Rename and change types and number of parameters
        fun newInstance(text: String): BlankFragment {
            val fragment = BlankFragment()
            val args = Bundle()
            args.putString(TEXT, text)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor