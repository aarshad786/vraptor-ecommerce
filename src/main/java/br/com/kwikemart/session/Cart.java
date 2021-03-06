package br.com.kwikemart.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.kwikemart.entity.CartItem;

@Component
@SessionScoped
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

	@Getter
	private HashMap<Long, CartItem> items = new HashMap<Long, CartItem>();

	public void addNewItem(CartItem item) {
		items.put(item.getProduct().getId(), item);
	}

	public void removeItem(Long id) {
		items.remove(id);
	}

	public void updateQuantity(Long id, Integer quantity) {
		CartItem cartItem = items.get(id);
		cartItem.setQuantity(quantity);
		items.put(id, cartItem);
	}

	public CartItem getItem(Long id) {
		return items.get(id);
	}

	public List<CartItem> getList() {
		return new ArrayList<CartItem>(this.getItems().values());
	}

	public void finish() {
		items = new HashMap<Long, CartItem>();
	}

}