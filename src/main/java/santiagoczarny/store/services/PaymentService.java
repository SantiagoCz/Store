package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.Payment;
import santiagoczarny.store.entities.Status;
import santiagoczarny.store.repositories.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public void delete(Payment payment){
        paymentRepository.delete(payment);
    }

    public void deactivate(Payment payment) {
        payment.setStatus(Status.INACTIVE);
        save(payment);
    }

}
