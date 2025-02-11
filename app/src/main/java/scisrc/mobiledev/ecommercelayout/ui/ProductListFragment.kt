package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout สำหรับ ProductListFragment
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ดำเนินการต่างๆ ใน fragment นี้ที่นี่
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // อย่าลืมล้างการอ้างอิง binding เมื่อ fragment ถูกทำลาย
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
