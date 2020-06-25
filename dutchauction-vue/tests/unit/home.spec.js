import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import HelloWorld from '@/components/HelloWorld.vue'

describe('HelloWorld.vue', () => {
  it('renders h1 title tag', () => {
    const wrapper = shallowMount(HelloWorld);
    expect(
      wrapper
      .find("h1")
      .text()
      ).equal("Welcome to Dutch Auction")
  });
});
