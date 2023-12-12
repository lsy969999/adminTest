class TestElement extends HTMLElement {
  constructor(){
    super();
  }

  connectedCallback() {
    console.log("custom element added to page")
  }

  disconnectedCallback() {
    console.log('custom element removed from page')
  }

  adoptedCallback() {
    console.log('custom element moved to new page')
  }

  attributeChangedCallback(name, oldValue, newValue) {
    console.log(`Attribute ${name} has changed, oldValue: ${oldValue} -> newValue: ${newValue}`);
  }
}

customElements.define('test-element', TestElement);