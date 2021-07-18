package devanmejia.productshopemail.model.params;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderParams extends AbstractParams{
    private Long id;
    private String orderStatus;
}
